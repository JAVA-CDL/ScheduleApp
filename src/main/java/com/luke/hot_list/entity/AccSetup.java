package com.luke.hot_list.entity;

public class AccSetup {
    private String name = "默认调教名称";
    private String carName = "bmw_m4_gt3";

    private BasicSetup basicSetup = new BasicSetup();
    private AdvancedSetup advancedSetup = new AdvancedSetup();
    private Integer trackBopType = 35;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public BasicSetup getBasicSetup() {
        return basicSetup;
    }

    public void setBasicSetup(BasicSetup basicSetup) {
        this.basicSetup = basicSetup;
    }

    public AdvancedSetup getAdvancedSetup() {
        return advancedSetup;
    }

    public void setAdvancedSetup(AdvancedSetup advancedSetup) {
        this.advancedSetup = advancedSetup;
    }

    public Integer getTrackBopType() {
        return trackBopType;
    }

    public void setTrackBopType(Integer trackBopType) {
        this.trackBopType = trackBopType;
    }

    /**
     * 基础调教
     */
    static class BasicSetup{
        private Tyres tyres = new Tyres();
        private Alignment alignment = new Alignment();
        private Electronics electronics = new Electronics();
        private Strategy strategy = new Strategy();

        public Tyres getTyres() {
            return tyres;
        }

        public void setTyres(Tyres tyres) {
            this.tyres = tyres;
        }

        public Alignment getAlignment() {
            return alignment;
        }

        public void setAlignment(Alignment alignment) {
            this.alignment = alignment;
        }

        public Electronics getElectronics() {
            return electronics;
        }

        public void setElectronics(Electronics electronics) {
            this.electronics = electronics;
        }

        public Strategy getStrategy() {
            return strategy;
        }

        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }
    }

    /**
     * 轮胎
     */
    static class Tyres{
        private Integer tyreCompound = 0;
        private Integer[] tyrePressure = {54,62,58,62};

        public Integer getTyreCompound() {
            return tyreCompound;
        }

        public void setTyreCompound(Integer tyreCompound) {
            this.tyreCompound = tyreCompound;
        }

        public Integer[] getTyrePressure() {
            return tyrePressure;
        }

        public void setTyrePressure(Integer[] tyrePressure) {
            this.tyrePressure = tyrePressure;
        }
    }

    static class Alignment{
        private Integer[] camber = {2,2,1,1};
        private Integer[] toe = {15,15,5,5};
        private Double[] staticCamber = {-3.9041497707366943, -3.8996367454528809, -2.5135843753814697, -2.510425329208374};
        private Double[] toeOutLinear = {7.9372133768629283e-05, 7.93759900261648e-05, 0.00011661212920444086, 0.00011662788892863318};
        private Integer casterLF = 13;
        private Integer casterRF = 13;
        private Integer steerRatio = 5;

        public Integer[] getCamber() {
            return camber;
        }

        public void setCamber(Integer[] camber) {
            this.camber = camber;
        }

        public Integer[] getToe() {
            return toe;
        }

        public void setToe(Integer[] toe) {
            this.toe = toe;
        }

        public Double[] getStaticCamber() {
            return staticCamber;
        }

        public void setStaticCamber(Double[] staticCamber) {
            this.staticCamber = staticCamber;
        }

        public Double[] getToeOutLinear() {
            return toeOutLinear;
        }

        public void setToeOutLinear(Double[] toeOutLinear) {
            this.toeOutLinear = toeOutLinear;
        }

        public Integer getCasterLF() {
            return casterLF;
        }

        public void setCasterLF(Integer casterLF) {
            this.casterLF = casterLF;
        }

        public Integer getCasterRF() {
            return casterRF;
        }

        public void setCasterRF(Integer casterRF) {
            this.casterRF = casterRF;
        }

        public Integer getSteerRatio() {
            return steerRatio;
        }

        public void setSteerRatio(Integer steerRatio) {
            this.steerRatio = steerRatio;
        }
    }

    static class Electronics{
        private Integer tC1 = 1;
        private Integer tC2 = 0;
        private Integer abs = 2;
        private Integer eCUMap = 0;
        private Integer fuelMix = 0;
        private Integer telemetryLaps = 5;

        public Integer gettC1() {
            return tC1;
        }

        public void settC1(Integer tC1) {
            this.tC1 = tC1;
        }

        public Integer gettC2() {
            return tC2;
        }

        public void settC2(Integer tC2) {
            this.tC2 = tC2;
        }

        public Integer getAbs() {
            return abs;
        }

        public void setAbs(Integer abs) {
            this.abs = abs;
        }

        public Integer geteCUMap() {
            return eCUMap;
        }

        public void seteCUMap(Integer eCUMap) {
            this.eCUMap = eCUMap;
        }

        public Integer getFuelMix() {
            return fuelMix;
        }

        public void setFuelMix(Integer fuelMix) {
            this.fuelMix = fuelMix;
        }

        public Integer getTelemetryLaps() {
            return telemetryLaps;
        }

        public void setTelemetryLaps(Integer telemetryLaps) {
            this.telemetryLaps = telemetryLaps;
        }
    }

    static class Strategy{
        private Integer fuel = 0;
        private Integer nPitStops = 0;
        private Integer tyreSet = 1;
        private Integer frontBrakePadCompound = 0;
        private Integer rearBrakePadCompound = 0;
        private PitStrategy[] pitStrategy = { new PitStrategy() };
        private Double fuelPerLap = 2.9000000953674316;

        public Integer getFuel() {
            return fuel;
        }

        public void setFuel(Integer fuel) {
            this.fuel = fuel;
        }

        public Integer getnPitStops() {
            return nPitStops;
        }

        public void setnPitStops(Integer nPitStops) {
            this.nPitStops = nPitStops;
        }

        public Integer getTyreSet() {
            return tyreSet;
        }

        public void setTyreSet(Integer tyreSet) {
            this.tyreSet = tyreSet;
        }

        public Integer getFrontBrakePadCompound() {
            return frontBrakePadCompound;
        }

        public void setFrontBrakePadCompound(Integer frontBrakePadCompound) {
            this.frontBrakePadCompound = frontBrakePadCompound;
        }

        public Integer getRearBrakePadCompound() {
            return rearBrakePadCompound;
        }

        public void setRearBrakePadCompound(Integer rearBrakePadCompound) {
            this.rearBrakePadCompound = rearBrakePadCompound;
        }

        public PitStrategy[] getPitStrategy() {
            return pitStrategy;
        }

        public void setPitStrategy(PitStrategy[] pitStrategy) {
            this.pitStrategy = pitStrategy;
        }

        public Double getFuelPerLap() {
            return fuelPerLap;
        }

        public void setFuelPerLap(Double fuelPerLap) {
            this.fuelPerLap = fuelPerLap;
        }
    }

    static class PitStrategy{
        private Integer fuelToAdd = 0;
        private Tyres tyres = new Tyres();
        private Integer tyreSet = 2;
        private Integer frontBrakePadCompound = 1;
        private Integer rearBrakePadCompound = 1;

        public Integer getFuelToAdd() {
            return fuelToAdd;
        }

        public void setFuelToAdd(Integer fuelToAdd) {
            this.fuelToAdd = fuelToAdd;
        }

        public Tyres getTyres() {
            return tyres;
        }

        public void setTyres(Tyres tyres) {
            this.tyres = tyres;
        }

        public Integer getTyreSet() {
            return tyreSet;
        }

        public void setTyreSet(Integer tyreSet) {
            this.tyreSet = tyreSet;
        }

        public Integer getFrontBrakePadCompound() {
            return frontBrakePadCompound;
        }

        public void setFrontBrakePadCompound(Integer frontBrakePadCompound) {
            this.frontBrakePadCompound = frontBrakePadCompound;
        }

        public Integer getRearBrakePadCompound() {
            return rearBrakePadCompound;
        }

        public void setRearBrakePadCompound(Integer rearBrakePadCompound) {
            this.rearBrakePadCompound = rearBrakePadCompound;
        }
    }

    static class AdvancedSetup{
        private MechanicalBalance mechanicalBalance = new MechanicalBalance();
        private Dampers dampers = new Dampers();
        private AeroBalance aeroBalance = new AeroBalance();
        private Drivetrain drivetrain = new Drivetrain();

        public MechanicalBalance getMechanicalBalance() {
            return mechanicalBalance;
        }

        public void setMechanicalBalance(MechanicalBalance mechanicalBalance) {
            this.mechanicalBalance = mechanicalBalance;
        }

        public Dampers getDampers() {
            return dampers;
        }

        public void setDampers(Dampers dampers) {
            this.dampers = dampers;
        }

        public AeroBalance getAeroBalance() {
            return aeroBalance;
        }

        public void setAeroBalance(AeroBalance aeroBalance) {
            this.aeroBalance = aeroBalance;
        }

        public Drivetrain getDrivetrain() {
            return drivetrain;
        }

        public void setDrivetrain(Drivetrain drivetrain) {
            this.drivetrain = drivetrain;
        }
    }

    static class  MechanicalBalance{
        private Integer aRBFront = 4;
        private Integer aRBRear = 1;
        private Integer[] wheelRate = {3,3,3,3};
        private Integer[] bumpStopRateUp = {3,3,2,2};
        private Integer[] bumpStopRateDn = {0,0,10,10};
        private Integer[] bumpStopRateWindow = {3,3,45,45};
        private Integer brakeTorque = 20;
        private Integer brakeBias = 15;

        public Integer getaRBFront() {
            return aRBFront;
        }

        public void setaRBFront(Integer aRBFront) {
            this.aRBFront = aRBFront;
        }

        public Integer getaRBRear() {
            return aRBRear;
        }

        public void setaRBRear(Integer aRBRear) {
            this.aRBRear = aRBRear;
        }

        public Integer[] getWheelRate() {
            return wheelRate;
        }

        public void setWheelRate(Integer[] wheelRate) {
            this.wheelRate = wheelRate;
        }

        public Integer[] getBumpStopRateUp() {
            return bumpStopRateUp;
        }

        public void setBumpStopRateUp(Integer[] bumpStopRateUp) {
            this.bumpStopRateUp = bumpStopRateUp;
        }

        public Integer[] getBumpStopRateDn() {
            return bumpStopRateDn;
        }

        public void setBumpStopRateDn(Integer[] bumpStopRateDn) {
            this.bumpStopRateDn = bumpStopRateDn;
        }

        public Integer[] getBumpStopRateWindow() {
            return bumpStopRateWindow;
        }

        public void setBumpStopRateWindow(Integer[] bumpStopRateWindow) {
            this.bumpStopRateWindow = bumpStopRateWindow;
        }

        public Integer getBrakeTorque() {
            return brakeTorque;
        }

        public void setBrakeTorque(Integer brakeTorque) {
            this.brakeTorque = brakeTorque;
        }

        public Integer getBrakeBias() {
            return brakeBias;
        }

        public void setBrakeBias(Integer brakeBias) {
            this.brakeBias = brakeBias;
        }
    }

    static class Dampers{
        private Integer[] bumpSlow = {20, 20, 18, 18};
        private Integer[] bumpFast = {20, 20, 15, 15};
        private Integer[] reboundSlow = {28, 28, 20, 20};
        private Integer[] reboundFast = {27, 27, 22, 22};

        public Integer[] getBumpSlow() {
            return bumpSlow;
        }

        public void setBumpSlow(Integer[] bumpSlow) {
            this.bumpSlow = bumpSlow;
        }

        public Integer[] getBumpFast() {
            return bumpFast;
        }

        public void setBumpFast(Integer[] bumpFast) {
            this.bumpFast = bumpFast;
        }

        public Integer[] getReboundSlow() {
            return reboundSlow;
        }

        public void setReboundSlow(Integer[] reboundSlow) {
            this.reboundSlow = reboundSlow;
        }

        public Integer[] getReboundFast() {
            return reboundFast;
        }

        public void setReboundFast(Integer[] reboundFast) {
            this.reboundFast = reboundFast;
        }
    }

    static class AeroBalance{
        private Integer[] rideHeight = {0,11,12,18};
        private Double[] rodLength = {20.253910064697266, 20.253910064697266, 3.5604064464569092, 3.5604064464569092};
        private Integer splitter = 0;
        private Integer rearWing = 6;
        private Integer[] brakeDuct = {4, 4};

        public Integer[] getRideHeight() {
            return rideHeight;
        }

        public void setRideHeight(Integer[] rideHeight) {
            this.rideHeight = rideHeight;
        }

        public Double[] getRodLength() {
            return rodLength;
        }

        public void setRodLength(Double[] rodLength) {
            this.rodLength = rodLength;
        }

        public Integer getSplitter() {
            return splitter;
        }

        public void setSplitter(Integer splitter) {
            this.splitter = splitter;
        }

        public Integer getRearWing() {
            return rearWing;
        }

        public void setRearWing(Integer rearWing) {
            this.rearWing = rearWing;
        }

        public Integer[] getBrakeDuct() {
            return brakeDuct;
        }

        public void setBrakeDuct(Integer[] brakeDuct) {
            this.brakeDuct = brakeDuct;
        }
    }

    static class Drivetrain{
        private Integer preload = 4;

        public Integer getPreload() {
            return preload;
        }

        public void setPreload(Integer preload) {
            this.preload = preload;
        }
    }
}
