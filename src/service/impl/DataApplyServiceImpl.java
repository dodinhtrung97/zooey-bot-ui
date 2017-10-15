package service.impl;

import constant.Constant;
import model.*;
import param.handler.*;
import service.DataApplyService;

import java.util.List;

/**
 * Created by Trung on 10/14/2017.
 */
public class DataApplyServiceImpl implements DataApplyService{
    /**
     * Inject data by object type
     * @param param
     * @param fileContent
     * @param modelWrapper
     * @param mode
     */
    public void applyData(String param, List<String> fileContent, ModelWrapper modelWrapper, String mode) {
        switch (mode) {
            case Constant.MODE_GENERAL:
                try {
                    this.applyGeneralData(param, fileContent, modelWrapper);
                } catch (IllegalArgumentException e) {
                    this.applyCountdownTimerData(param, fileContent, modelWrapper);
                }
                break;
            case Constant.MODE_SLAVE:
                this.applySlaveModeData(param, fileContent, modelWrapper);
                break;
            case Constant.MODE_INPUT:
                this.applyInputData(param, fileContent, modelWrapper);
                break;
            case Constant.MODE_PARTY_SELECTION:
                this.applyPartySelectionData(param, fileContent, modelWrapper);
                break;
            case Constant.MODE_SUMMON:
                this.applySummonData(param, fileContent, modelWrapper);
                break;
            case Constant.MODE_COMBAT:
                this.applyCombatData(param, fileContent, modelWrapper);
                break;
            case Constant.MODE_EVENT:
                this.applyEventModeData(param, fileContent, modelWrapper);
                break;
            case Constant.MODE_TREASURE_EVENT:
                this.applyTreasureEventModeData(param, fileContent, modelWrapper);
                break;
            case Constant.MODE_SOLO_COOP:
                this.applySoloCoopModeData(param, fileContent, modelWrapper);
                break;
            case Constant.MODE_CUSTOMIZED_SCHEDULING:
                this.applyCustomizedSchedulingData(param, fileContent, modelWrapper);
                break;
            case Constant.MODE_ALERTING:
                this.applyAlertingData(param, fileContent, modelWrapper);
                break;
            case Constant.MODE_DIMENSIONAL_HALO:
                this.applyDimensionalHaloData(param, fileContent, modelWrapper);
                break;
        }
    }

    /**
     * Inject data to General Object
     * @param param
     * @param modelWrapper
     */
    private void applyGeneralData(String param, List<String> fileContent, ModelWrapper modelWrapper) {
        General general = modelWrapper.getGeneral();

        GeneralDataHandler generalDataHandler = new GeneralDataHandler();
        generalDataHandler.setGeneral(general);
        generalDataHandler.setFileContent(fileContent);

        generalDataHandler.handleApplyData(param);
    }

    /**
     * Inject data to CountdownTimer Object
     * @param param
     * @param modelWrapper
     */
    private void applyCountdownTimerData(String param, List<String> fileContent, ModelWrapper modelWrapper) {
        CountdownTimer countdownTimer = modelWrapper.getCountdownTimer();

        CountdownTimerDataHandler countdownTimerDataHandler = new CountdownTimerDataHandler();
        countdownTimerDataHandler.setCountdownTimer(countdownTimer);
        countdownTimerDataHandler.setFileContent(fileContent);

        countdownTimerDataHandler.handleApplyData(param);
    }

    /**
     * Inject data to SlaveMode Object
     * @param param
     * @param modelWrapper
     */
    private void applySlaveModeData(String param, List<String> fileContent, ModelWrapper modelWrapper) {
        SlaveMode slaveMode = modelWrapper.getSlaveMode();

        SlaveModeDataHandler slaveModeDataHandler = new SlaveModeDataHandler();
        slaveModeDataHandler.setSlaveMode(slaveMode);
        slaveModeDataHandler.setFileContent(fileContent);

        slaveModeDataHandler.handleApplyData(param);
    }

    /**
     * Inject data to Input Object
     * @param param
     * @param modelWrapper
     */
    private void applyInputData(String param, List<String> fileContent, ModelWrapper modelWrapper) {
        Input input = modelWrapper.getInput();

        InputDataHandler inputDataHandler = new InputDataHandler();
        inputDataHandler.setInput(input);
        inputDataHandler.setFileContent(fileContent);

        inputDataHandler.handleApplyData(param);
    }

    /**
     * Inject data to PartySelection Object
     * @param param
     * @param modelWrapper
     */
    private void applyPartySelectionData(String param, List<String> fileContent, ModelWrapper modelWrapper) {
        PartySelection partySelection = modelWrapper.getPartySelection();

        PartySelectionDataHandler partySelectionDataHandler = new PartySelectionDataHandler();
        partySelectionDataHandler.setPartySelection(partySelection);
        partySelectionDataHandler.setFileContent(fileContent);

        partySelectionDataHandler.handleApplyData(param);
    }

    /**
     * Inject data to Summon Object
     * @param param
     * @param modelWrapper
     */
    private void applySummonData(String param, List<String> fileContent, ModelWrapper modelWrapper) {
        Summon summon = modelWrapper.getSummon();

        SummonDataHandler summonDataHandler = new SummonDataHandler();
        summonDataHandler.setSummon(summon);
        summonDataHandler.setFileContent(fileContent);

        summonDataHandler.handleApplyData(param);
    }

    /**
     * Inject data to Combat Object
     * @param param
     * @param modelWrapper
     */
    private void applyCombatData(String param, List<String> fileContent, ModelWrapper modelWrapper) {
        Combat combat = modelWrapper.getCombat();

        CombatDataHandler combatDataHandler = new CombatDataHandler();
        combatDataHandler.setCombat(combat);
        combatDataHandler.setFileContent(fileContent);

        combatDataHandler.handleApplyData(param);
    }

    /**
     * Inject data to EventMode Object
     * @param param
     * @param modelWrapper
     */
    private void applyEventModeData(String param, List<String> fileContent, ModelWrapper modelWrapper) {
        EventMode eventMode = modelWrapper.getEventMode();

        EventModeDataHandler eventModeDataHandler = new EventModeDataHandler();
        eventModeDataHandler.setEventMode(eventMode);
        eventModeDataHandler.setFileContent(fileContent);

        eventModeDataHandler.handleApplyData(param);
    }

    /**
     * Inject data to TreasureEventMode Object
     * @param param
     * @param modelWrapper
     */
    private void applyTreasureEventModeData(String param, List<String> fileContent, ModelWrapper modelWrapper) {
        TreasureEventMode treasureEventMode = modelWrapper.getTreasureEventMode();

        TreasureEventModeDataHandler treasureEventModeDataHandler = new TreasureEventModeDataHandler();
        treasureEventModeDataHandler.setTreasureEventMode(treasureEventMode);
        treasureEventModeDataHandler.setFileContent(fileContent);

        treasureEventModeDataHandler.handleApplyData(param);
    }

    /**
     * Inject data to SoloCoopMode Object
     * @param param
     * @param modelWrapper
     */
    private void applySoloCoopModeData(String param, List<String> fileContent, ModelWrapper modelWrapper) {
        SoloCoopMode soloCoopMode = modelWrapper.getSoloCoopMode();

        SoloCoopModeDataHandler soloCoopModeDataHandler = new SoloCoopModeDataHandler();
        soloCoopModeDataHandler.setSoloCoopMode(soloCoopMode);
        soloCoopModeDataHandler.setFileContent(fileContent);

        soloCoopModeDataHandler.handleApplyData(param);
    }

    /**
     * Inject data to CustomizedScheduling Object
     * @param param
     * @param modelWrapper
     */
    private void applyCustomizedSchedulingData(String param, List<String> fileContent, ModelWrapper modelWrapper) {
        CustomizedScheduling customizedScheduling = modelWrapper.getCustomizedScheduling();

        CustomizedSchedulingDataHandler customizedSchedulingDataHandler = new CustomizedSchedulingDataHandler();
        customizedSchedulingDataHandler.setCustomizedScheduling(customizedScheduling);
        customizedSchedulingDataHandler.setFileContent(fileContent);

        customizedSchedulingDataHandler.handleApplyData(param);
    }

    /**
     * Inject data to Alerting Object
     * @param param
     * @param modelWrapper
     */
    private void applyAlertingData(String param, List<String> fileContent, ModelWrapper modelWrapper) {
        Alerting alerting = modelWrapper.getAlerting();

        AlertingDataHandler alertingDataHandler = new AlertingDataHandler();
        alertingDataHandler.setAlerting(alerting);
        alertingDataHandler.setFileContent(fileContent);

        alertingDataHandler.handleApplyData(param);
    }

    /**
     * Inject data to DimensionalHalo Object
     * @param param
     * @param modelWrapper
     */
    private void applyDimensionalHaloData(String param, List<String> fileContent, ModelWrapper modelWrapper) {
        DimensionalHalo dimensionalHalo = modelWrapper.getDimensionalHalo();

        DimensionalHaloDataHandler dimensionalHaloDataHandler = new DimensionalHaloDataHandler();
        dimensionalHaloDataHandler.setDimensionalHalo(dimensionalHalo);
        dimensionalHaloDataHandler.setFileContent(fileContent);

        dimensionalHaloDataHandler.handleApplyData(param);
    }
}
