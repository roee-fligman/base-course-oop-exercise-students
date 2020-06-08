package AerialVehicles.FighterJets;

import AerialVehicles.AerialAttackVehicle;
import AerialVehicles.AerialIntelligenceVehicle;
import AerialVehicles.AerialVehicle;
import Missions.AttackMission;
import Missions.IntelligenceMission;
import Missions.Mission;
import Missions.MissionTypeException;

public class F15 extends AerialVehicle implements AerialIntelligenceVehicle, AerialAttackVehicle {
  private final int REPAIR_TIME = 250;
  private int numberOfMissiles;
  private String missileType;
  private String sensorType;

  public F15(
      String sensorType,
      int numberOfMissiles,
      String missileType,
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
  public void check() {
    if (getHoursOfFlightSinceLastRepair() > REPAIR_TIME) {
      repair();
    }
  }

  @Override
  public String collectIntelligence() {
    return (getPilotName()
        + ": F15 Collecting Data in "
        + ((IntelligenceMission) getMission()).getRegion()
        + " with sensor type: "
        + sensorType);
  }

  @Override
  public String attack() {
    return (getPilotName()
        + ": F15 Attacking "
        + ((AttackMission) getMission()).getTarget()
        + " with: "
        + missileType
        + "X"
        + numberOfMissiles);
  }
}
