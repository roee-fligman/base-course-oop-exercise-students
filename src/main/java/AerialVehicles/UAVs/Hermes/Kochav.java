package AerialVehicles.UAVs.Hermes;

import AerialVehicles.AerialAttackVehicle;
import AerialVehicles.AerialBdaVehicle;
import AerialVehicles.AerialIntelligenceVehicle;
import AerialVehicles.AerialVehicle;
import Missions.*;

public class Kochav extends AerialVehicle
    implements AerialIntelligenceVehicle, AerialAttackVehicle, AerialBdaVehicle {
  private final int REPAIR_TIME = 100;
  private int numberOfMissiles;
  private String missileType;
  private String sensorType;
  private String cameraType;

  public Kochav(
      int numberOfMissiles,
      String missileType,
      String cameraType,
      String sensorType,
      String pilotName,
      Mission mission,
      int hoursOfFlightSinceLastRepair,
      Boolean flightStatus) {
    super(pilotName, mission, hoursOfFlightSinceLastRepair, flightStatus);
    this.numberOfMissiles = numberOfMissiles;
    this.missileType = missileType;
    this.sensorType = sensorType;
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

  @Override
  public void check() {
    if (getHoursOfFlightSinceLastRepair() > REPAIR_TIME) {
      repair();
    }
  }

  @Override
  public String collectIntelligence() {
    return (getPilotName()
        + ": Kochav Collecting Data in "
        + ((IntelligenceMission) getMission()).getRegion()
        + " with sensor type: "
        + sensorType);
  }

  @Override
  public String attack() {
    return (getPilotName()
        + ": Kochav Attacking "
        + ((AttackMission) getMission()).getTarget()
        + " with: "
        + missileType
        + "X"
        + numberOfMissiles);
  }

  @Override
  public String preformBda() {
    return (getPilotName()
        + ": Kochav taking pictures of "
        + ((BdaMission) getMission()).getObjective()
        + " with: "
        + cameraType + " camera");
  }
}
