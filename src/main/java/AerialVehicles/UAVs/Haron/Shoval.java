package AerialVehicles.UAVs.Haron;

import AerialVehicles.AerialAttackVehicle;
import AerialVehicles.AerialBdaVehicle;
import AerialVehicles.AerialIntelligenceVehicle;
import AerialVehicles.AerialVehicle;
import Missions.*;

public class Shoval extends AerialVehicle
    implements AerialIntelligenceVehicle, AerialBdaVehicle, AerialAttackVehicle {
  private final int REPAIR_TIME = 150;
  private String sensorType;
  private String cameraType;
  private int numberOfMissiles;
  private String missileType;

  public Shoval(
      String cameraType,
      int numberOfMissiles,
      String missileType,
      String sensorType,
      String pilotName,
      Mission mission,
      int hoursOfFlightSinceLastRepair,
      Boolean flightStatus) {
    super(pilotName, mission, hoursOfFlightSinceLastRepair, flightStatus);
    this.sensorType = sensorType;
    this.cameraType = cameraType;
    this.numberOfMissiles = numberOfMissiles;
    this.missileType = missileType;
  }

  public String getSensorType() {
    return sensorType;
  }

  public void setSensorType(String sensorType) {
    this.sensorType = sensorType;
  }

  public String getCameraType() {
    return cameraType;
  }

  public void setCameraType(String cameraType) {
    this.cameraType = cameraType;
  }

  public int getNumberOfMissiles() {
    return numberOfMissiles;
  }

  public void setNumberOfMissiles(int numberOfMissiles) {
    this.numberOfMissiles = numberOfMissiles;
  }

  public String getMissileType() {
    return missileType;
  }

  public void setMissileType(String missileType) {
    this.missileType = missileType;
  }

  @Override
  public void check() {
    if (getHoursOfFlightSinceLastRepair() > REPAIR_TIME) {
      repair();
    }
  }

  @Override
  public String collectIntelligence() {
    return (getPilotName()
        + ": Shoval Collecting Data in "
        + ((IntelligenceMission) getMission()).getRegion()
        + " with sensor type: "
        + sensorType);
  }

  @Override
  public String preformBda() {
    return (getPilotName()
        + ": Shoval taking pictures of "
        + ((BdaMission) getMission()).getObjective()
        + " with: "
        + cameraType + " camera");
  }

  @Override
  public String attack() {
    return (getPilotName()
        + ": Shoval Attacking "
        + ((AttackMission) getMission()).getTarget()
        + " with: "
        + missileType
        + "X"
        + numberOfMissiles);
  }
}
