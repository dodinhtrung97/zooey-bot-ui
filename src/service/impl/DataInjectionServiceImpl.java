package service.impl;

import constant.Constant;
import model.*;
import param.handler.*;
import service.DataInjectionService;

/**
 * Created by Trung on 10/14/2017.
 */
public class DataInjectionServiceImpl implements DataInjectionService{
    /**
     * Inject data by object type
     * @param line
     * @param modelWrapper
     * @param model
     */
    public void injectData(String line, ModelWrapper modelWrapper, String model) {

        String param;
        String paramValue;

        // In case no paramValue
        try {
            param = line.split("=")[0];
            paramValue = line.split("=")[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            param = line.substring(0, line.length()-1);
            paramValue = "";
        }

        switch (model) {
            case Constant.MODE_GENERAL:
                try {
                    this.injectGeneralData(param, paramValue, modelWrapper);
                } catch (IllegalArgumentException e) {
                    this.injectCountdownTimerData(param, paramValue, modelWrapper);
                }
                break;
            case Constant.MODE_SLAVE:
                this.injectSlaveModeData(param, paramValue, modelWrapper);
                break;
            case Constant.MODE_INPUT:
                this.injectInputData(param, paramValue, modelWrapper);
                break;
            case Constant.MODE_PARTY_SELECTION:
                this.injectPartySelectionData(param, paramValue, modelWrapper);
                break;
            case Constant.MODE_SUMMON:
                this.injectSummonData(param, paramValue, modelWrapper);
                break;
            case Constant.MODE_COMBAT:
                this.injectCombatData(param, paramValue, modelWrapper);
                break;
            case Constant.MODE_EVENT:
                this.injectEventModeData(param, paramValue, modelWrapper);
                break;
            case Constant.MODE_TREASURE_EVENT:
                this.injectTreasureEventModeData(param, paramValue, modelWrapper);
                break;
            case Constant.MODE_SOLO_COOP:
                this.injectSoloCoopModeData(param, paramValue, modelWrapper);
                break;
            case Constant.MODE_CUSTOMIZED_SCHEDULING:
                this.injectCustomizedSchedulingData(param, paramValue, modelWrapper);
                break;
            case Constant.MODE_ALERTING:
                this.injectAlertingData(param, paramValue, modelWrapper);
                break;
            case Constant.MODE_DIMENSIONAL_HALO:
                this.injectDimensionalHaloData(param, paramValue, modelWrapper);
                break;
        }
    }

    /**
     * Inject data to General Object
     * @param param
     * @param paramValue
     * @param modelWrapper
     */
    private void injectGeneralData(String param, String paramValue, ModelWrapper modelWrapper) {
        General general = modelWrapper.getGeneral();

        GeneralDataHandler generalDataHandler = new GeneralDataHandler();
        generalDataHandler.setGeneral(general);
        generalDataHandler.setParamValue(paramValue);

        generalDataHandler.handleInject(param);
    }

    /**
     * Inject data to CountdownTimer Object
     * @param param
     * @param paramValue
     * @param modelWrapper
     */
    private void injectCountdownTimerData(String param, String paramValue, ModelWrapper modelWrapper) {
        CountdownTimer countdownTimer = modelWrapper.getCountdownTimer();

        CountdownTimerDataHandler countdownTimerDataHandler = new CountdownTimerDataHandler();
        countdownTimerDataHandler.setCountdownTimer(countdownTimer);
        countdownTimerDataHandler.setParamValue(paramValue);

        countdownTimerDataHandler.handleInject(param);
    }

    /**
     * Inject data to SlaveMode Object
     * @param param
     * @param paramValue
     * @param modelWrapper
     */
    private void injectSlaveModeData(String param, String paramValue, ModelWrapper modelWrapper) {
        SlaveMode slaveMode = modelWrapper.getSlaveMode();

        SlaveModeDataHandler slaveModeDataHandler = new SlaveModeDataHandler();
        slaveModeDataHandler.setSlaveMode(slaveMode);
        slaveModeDataHandler.setParamValue(paramValue);

        slaveModeDataHandler.handleInject(param);
    }

    /**
     * Inject data to Input Object
     * @param param
     * @param paramValue
     * @param modelWrapper
     */
    private void injectInputData(String param, String paramValue, ModelWrapper modelWrapper) {
        Input input = modelWrapper.getInput();

        InputDataHandler inputDataHandler = new InputDataHandler();
        inputDataHandler.setInput(input);
        inputDataHandler.setParamValue(paramValue);

        inputDataHandler.handleInject(param);
    }

    /**
     * Inject data to PartySelection Object
     * @param param
     * @param paramValue
     * @param modelWrapper
     */
    private void injectPartySelectionData(String param, String paramValue, ModelWrapper modelWrapper) {
        PartySelection partySelection = modelWrapper.getPartySelection();

        PartySelectionDataHandler partySelectionDataHandler = new PartySelectionDataHandler();
        partySelectionDataHandler.setPartySelection(partySelection);
        partySelectionDataHandler.setParamValue(paramValue);

        partySelectionDataHandler.handleInject(param);
    }

    /**
     * Inject data to Summon Object
     * @param param
     * @param paramValue
     * @param modelWrapper
     */
    private void injectSummonData(String param, String paramValue, ModelWrapper modelWrapper) {
        Summon summon = modelWrapper.getSummon();

        SummonDataHandler summonDataHandler = new SummonDataHandler();
        summonDataHandler.setSummon(summon);
        summonDataHandler.setParamValue(paramValue);

        summonDataHandler.handleInject(param);
    }

    /**
     * Inject data to Combat Object
     * @param param
     * @param paramValue
     * @param modelWrapper
     */
    private void injectCombatData(String param, String paramValue, ModelWrapper modelWrapper) {
        Combat combat = modelWrapper.getCombat();

        CombatDataHandler combatDataHandler = new CombatDataHandler();
        combatDataHandler.setCombat(combat);
        combatDataHandler.setParamValue(paramValue);

        combatDataHandler.handleInject(param);
    }

    /**
     * Inject data to EventMode Object
     * @param param
     * @param paramValue
     * @param modelWrapper
     */
    private void injectEventModeData(String param, String paramValue, ModelWrapper modelWrapper) {
        EventMode eventMode = modelWrapper.getEventMode();

        EventModeDataHandler eventModeDataHandler = new EventModeDataHandler();
        eventModeDataHandler.setEventMode(eventMode);
        eventModeDataHandler.setParamValue(paramValue);

        eventModeDataHandler.handleInject(param);
    }

    /**
     * Inject data to TreasureEventMode Object
     * @param param
     * @param paramValue
     * @param modelWrapper
     */
    private void injectTreasureEventModeData(String param, String paramValue, ModelWrapper modelWrapper) {
        TreasureEventMode treasureEventMode = modelWrapper.getTreasureEventMode();

        TreasureEventModeDataHandler treasureEventModeDataHandler = new TreasureEventModeDataHandler();
        treasureEventModeDataHandler.setTreasureEventMode(treasureEventMode);
        treasureEventModeDataHandler.setParamValue(paramValue);

        treasureEventModeDataHandler.handleInject(param);
    }

    /**
     * Inject data to SoloCoopMode Object
     * @param param
     * @param paramValue
     * @param modelWrapper
     */
    private void injectSoloCoopModeData(String param, String paramValue, ModelWrapper modelWrapper) {
        SoloCoopMode soloCoopMode = modelWrapper.getSoloCoopMode();

        SoloCoopModeDataHandler soloCoopModeDataHandler = new SoloCoopModeDataHandler();
        soloCoopModeDataHandler.setSoloCoopMode(soloCoopMode);
        soloCoopModeDataHandler.setParamValue(paramValue);

        soloCoopModeDataHandler.handleInject(param);
    }

    /**
     * Inject data to CustomizedScheduling Object
     * @param param
     * @param paramValue
     * @param modelWrapper
     */
    private void injectCustomizedSchedulingData(String param, String paramValue, ModelWrapper modelWrapper) {
        CustomizedScheduling customizedScheduling = modelWrapper.getCustomizedScheduling();

        CustomizedSchedulingDataHandler customizedSchedulingDataHandler = new CustomizedSchedulingDataHandler();
        customizedSchedulingDataHandler.setCustomizedScheduling(customizedScheduling);
        customizedSchedulingDataHandler.setParamValue(paramValue);

        customizedSchedulingDataHandler.handleInject(param);
    }

    /**
     * Inject data to Alerting Object
     * @param param
     * @param paramValue
     * @param modelWrapper
     */
    private void injectAlertingData(String param, String paramValue, ModelWrapper modelWrapper) {
        Alerting alerting = modelWrapper.getAlerting();

        AlertingDataHandler alertingDataHandler = new AlertingDataHandler();
        alertingDataHandler.setAlerting(alerting);
        alertingDataHandler.setParamValue(paramValue);

        alertingDataHandler.handleInject(param);
    }

    /**
     * Inject data to DimensionalHalo Object
     * @param param
     * @param paramValue
     * @param modelWrapper
     */
    private void injectDimensionalHaloData(String param, String paramValue, ModelWrapper modelWrapper) {
        DimensionalHalo dimensionalHalo = modelWrapper.getDimensionalHalo();

        DimensionalHaloDataHandler dimensionalHaloDataHandler = new DimensionalHaloDataHandler();
        dimensionalHaloDataHandler.setDimensionalHalo(dimensionalHalo);
        dimensionalHaloDataHandler.setParamValue(paramValue);

        dimensionalHaloDataHandler.handleInject(param);
    }
}
