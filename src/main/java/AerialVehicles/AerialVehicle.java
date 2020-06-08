package AerialVehicles;

import AerialVehicles.FighterJets.F15;
import AerialVehicles.FighterJets.F16;
import AerialVehicles.UAVs.Haron.Eitan;
import AerialVehicles.UAVs.Haron.Shoval;
import AerialVehicles.UAVs.Hermes.Kochav;
import AerialVehicles.UAVs.Hermes.Zik;
import Entities.Coordinates;
import Missions.Mission;
import Missions.MissionTypeException;

public abstract class AerialVehicle implements AerialVehicleService {
  private static final int FIGHTER_JETS_REPAIR_TIME = 250;
  private static final int HARON_REPAIR_TIME = 150;
  private static final int HERMES_REPAIR_TIME = 100;
  private String pilotName;
  private Mission mission;
  private int hoursOfFlightSinceLastRepair;
  private Boolean flightStatus;

  public AerialVehicle(
      String pilotName, Mission mission, int hoursOfFlightSinceLastRepair, Boolean flightStatus) {
    this.pilotName = pilotName;
    this.mission = mission;
    this.hoursOfFlightSinceLastRepair = hoursOfFlightSinceLastRepair;
    this.flightStatus = flightStatus;
  }

  public String getPilotName() {
    return pilotName;
  }

  public void setPilotName(String pilotName) {
    this.pilotName = pilotName;
  }

  public Mission getMission() {
    return mission;
  }

  public void setMission(Mission mission) {
    this.mission = mission;
  }

  public int getHoursOfFlightSinceLastRepair() {
    return hoursOfFlightSinceLastRepair;
  }

  public void setHoursOfFlightSinceLastRepair(int hoursOfFlightSinceLastRepair) {
    this.hoursOfFlightSinceLastRepair = hoursOfFlightSinceLastRepair;
  }

  public Boolean getFlightStatus() {
    return flightStatus;
  }

  public void setFlightStatus(Boolean flightStatus) {
    this.flightStatus = flightStatus;
  }

  @Override
  public void flyTo() {
    System.out.println("Flying to: " + mission.getCoordinates().toString());
  }

  @Override
  public void land() {
    System.out.println("Landing");
  }

  @Override
  public void check() {
    if (this instanceof F15 || this instanceof F16) {
      if (getHoursOfFlightSinceLastRepair() > FIGHTER_JETS_REPAIR_TIME) {
        repair();
      }
    } else if (this instanceof Eitan || this instanceof Shoval) {
      if (getHoursOfFlightSinceLastRepair() > HARON_REPAIR_TIME) {
        repair();
      }
    } else if (this instanceof Kochav || this instanceof Zik) {
      if (getHoursOfFlightSinceLastRepair() > HERMES_REPAIR_TIME) {
        repair();
      }
    }
  }

  @Override
  public void repair() {
    flightStatus = true;
    hoursOfFlightSinceLastRepair = 0;
  }
}
