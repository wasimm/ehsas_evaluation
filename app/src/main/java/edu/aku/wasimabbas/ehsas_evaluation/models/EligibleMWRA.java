package edu.aku.wasimabbas.ehsas_evaluation.models;

import android.database.Cursor;

import androidx.lifecycle.LiveData;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.wasimabbas.ehsas_evaluation.contracts.EligibleMWRAsContract;

public class EligibleMWRA extends LiveData<EligibleMWRA> {

    private final String projectName = "EHSAAS_NASHONUMA";
    // Variables
    public String mwra_json = "";
    private String endingdatetime = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";
    private String deviceid = "";
    private String devicetagid = "";
    // Other Variables
    private String id = "id";
    private String uid = "uid";
    private String muid = "muid";
    private String fuid = "fuid";
    private String istatus = "";
    private String istatus96x = "";
    private String sysdate = "";
    private String username = "";

    public EligibleMWRA() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMuid() {
        return muid;
    }

    public void setMuid(String muid) {
        this.muid = muid;
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid;
    }

    public String getSysdate() {
        return sysdate;
    }

    public void setSysdate(String sysdate) {
        this.sysdate = sysdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public String getIstatus96x() {
        return istatus96x;
    }

    public void setIstatus96x(String istatus96x) {
        this.istatus96x = istatus96x;
    }

    public String getEndingdatetime() {
        return endingdatetime;
    }

    public void setEndingdatetime(String endingdatetime) {
        this.endingdatetime = endingdatetime;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getDeviceTagid() {
        return devicetagid;
    }

    public void setDeviceTagid(String tagid) {
        this.devicetagid = tagid;
    }

    public String getJSON() {
        return mwra_json;
    }

    public void setJSON(String mwra_json) {
        this.mwra_json = mwra_json;
    }

    public EligibleMWRA Sync(JSONObject jsonObject) throws JSONException {

        this.id = jsonObject.getString(EligibleMWRAsContract.MWRAsTable.COLUMN_ID);
        this.uid = jsonObject.getString(EligibleMWRAsContract.MWRAsTable.COLUMN_UID);
        this.fuid = jsonObject.getString(EligibleMWRAsContract.MWRAsTable.COLUMN_FUID);
        this.istatus = jsonObject.getString(EligibleMWRAsContract.MWRAsTable.COLUMN_ISTATUS);
        this.istatus96x = jsonObject.getString(EligibleMWRAsContract.MWRAsTable.COLUMN_ISTATUS96x);
        this.endingdatetime = jsonObject.getString(EligibleMWRAsContract.MWRAsTable.COLUMN_ENDINGDATETIME);
        this.synced = jsonObject.getString(EligibleMWRAsContract.MWRAsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(EligibleMWRAsContract.MWRAsTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(EligibleMWRAsContract.MWRAsTable.COLUMN_APPVERSION);
        this.deviceid = jsonObject.getString(EligibleMWRAsContract.MWRAsTable.COLUMN_DEVICEID);
        this.devicetagid = jsonObject.getString(EligibleMWRAsContract.MWRAsTable.COLUMN_DEVICETAGID);
        this.sysdate = jsonObject.getString(EligibleMWRAsContract.MWRAsTable.COLUMN_SYSDATE);
        this.username = jsonObject.getString(EligibleMWRAsContract.MWRAsTable.COLUMN_USERNAME);
        this.mwra_json = jsonObject.getString(EligibleMWRAsContract.MWRAsTable.COLUMN_JSON);

        return this;
    }


    public EligibleMWRA Hydrate(Cursor cursor) {

        this.id = cursor.getString(cursor.getColumnIndex(EligibleMWRAsContract.MWRAsTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(EligibleMWRAsContract.MWRAsTable.COLUMN_UID));
        this.fuid = cursor.getString(cursor.getColumnIndex(EligibleMWRAsContract.MWRAsTable.COLUMN_FUID));
        this.istatus = cursor.getString(cursor.getColumnIndex(EligibleMWRAsContract.MWRAsTable.COLUMN_ISTATUS));
        this.istatus96x = cursor.getString(cursor.getColumnIndex(EligibleMWRAsContract.MWRAsTable.COLUMN_ISTATUS96x));
        this.endingdatetime = cursor.getString(cursor.getColumnIndex(EligibleMWRAsContract.MWRAsTable.COLUMN_ENDINGDATETIME));
        this.appversion = cursor.getString(cursor.getColumnIndex(EligibleMWRAsContract.MWRAsTable.COLUMN_APPVERSION));
        this.deviceid = cursor.getString(cursor.getColumnIndex(EligibleMWRAsContract.MWRAsTable.COLUMN_DEVICEID));
        this.devicetagid = cursor.getString(cursor.getColumnIndex(EligibleMWRAsContract.MWRAsTable.COLUMN_DEVICETAGID));
        this.sysdate = cursor.getString(cursor.getColumnIndex(EligibleMWRAsContract.MWRAsTable.COLUMN_SYSDATE));
        this.username = cursor.getString(cursor.getColumnIndex(EligibleMWRAsContract.MWRAsTable.COLUMN_USERNAME));
        this.mwra_json = cursor.getString(cursor.getColumnIndex(EligibleMWRAsContract.MWRAsTable.COLUMN_JSON));

        return this;
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(EligibleMWRAsContract.MWRAsTable.COLUMN_ID, this.id == null ? JSONObject.NULL : this.id);
        json.put(EligibleMWRAsContract.MWRAsTable.COLUMN_UID, this.uid == null ? JSONObject.NULL : this.uid);
        json.put(EligibleMWRAsContract.MWRAsTable.COLUMN_FUID, this.fuid == null ? JSONObject.NULL : this.fuid);
        json.put(EligibleMWRAsContract.MWRAsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(EligibleMWRAsContract.MWRAsTable.COLUMN_ISTATUS96x, this.istatus96x == null ? JSONObject.NULL : this.istatus96x);
        json.put(EligibleMWRAsContract.MWRAsTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);
        json.put(EligibleMWRAsContract.MWRAsTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);
        json.put(EligibleMWRAsContract.MWRAsTable.COLUMN_DEVICEID, this.deviceid == null ? JSONObject.NULL : this.deviceid);
        json.put(EligibleMWRAsContract.MWRAsTable.COLUMN_DEVICETAGID, this.devicetagid == null ? JSONObject.NULL : this.devicetagid);
        json.put(EligibleMWRAsContract.MWRAsTable.COLUMN_SYSDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
        json.put(EligibleMWRAsContract.MWRAsTable.COLUMN_USERNAME, this.username == null ? JSONObject.NULL : this.username);

        if (!this.mwra_json.equals("")) {
            json.put(EligibleMWRAsContract.MWRAsTable.COLUMN_JSON, this.mwra_json.equals("") ? JSONObject.NULL : new JSONObject(this.mwra_json));
        }

        return json;
    }
}
