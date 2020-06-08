package AerialVehicles.UAVs.Haron;

import AerialVehicles.AerialAttackVehicle;
import AerialVehicles.AerialIntelligenceVehicle;
import AerialVehicles.AerialVehicle;
import Missions.AttackMission;
import Missions.IntelligenceMission;
import Missions.Mission;
import Missions.MissionTypeException;

public class Eitan extends AerialVehicle implements AerialIntelligenceVehicle, AerialAttackVehicle {
  private int numberOfMissiles;
  private String missileType;
  private String sensorType;

  public Eitan(
      int numberOfMissiles,
      String missileType,
      String sensorType,
      String pilotName,
      Mission mission,
      int flightHoursSinceTheLastPatch,
      Boolean flightStatus) {
    super(pilotName, mission, flightHoursSinceTheLastPatch, flightStatus);
    this.numberOfMissiles = numberOfMissiles;
    this.missileType = missileType;
    this.sensorType = sensorType;
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

  @Override
  public String collectIntelligence() {
    return (getPilotName()
        + ": "
        + getClass().getSimpleName()
        + " Collecting Data in "
        + ((IntelligenceMission) getMission()).getRegion()
        + " with sensor type: "
        + sensorType);
  }

  @Override
  public String attack() {
    return (getPilotName()
        + ": "
        + getClass().getSimpleName()
        + " Attacking "
        + ((AttackMission) getMission()).getTarget()
        + " with: "
        + missileType
        + "X"
        + numberOfMissiles);
  }
}
