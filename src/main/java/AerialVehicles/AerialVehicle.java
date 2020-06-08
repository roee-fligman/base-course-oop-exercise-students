package AerialVehicles;

import AerialVehicles.FighterJets.F15;
import Entities.Coordinates;
import Missions.Mission;
import Missions.MissionTypeException;

public abstract class AerialVehicle implements AerialVehicleService {
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
  public void repair() {
    flightStatus = true;
    hoursOfFlightSinceLastRepair = 0;
  }
}
