package edu.aku.wasimabbas.ehsas_evaluation.models;

import android.database.Cursor;

import androidx.lifecycle.LiveData;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.wasimabbas.ehsas_evaluation.contracts.FormsContract.FormsTable;

public class Form extends LiveData<Form> {

    private final String projectName = "EHSAS_NASHONUMA";
    // Form Variables
    public String form_json = "";
    private String endingdatetime = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";
    private String deviceid = "";
    private String devicetagid = "";
    // Other Variables
    private String id = "id";
    private String uid = "uid";
    private String istatus = "";
    private String istatus96x = "";
    private String sysdate = "";
    private String username = "";

    private String H213 = "";
    private String H214 = "";

    private String H21501 = "";
    private String H21502 = "";

    private String H21601 = "";
    private String H21602 = "";

    private String H21701 = "";
    private String H21702 = "";

    public Form() {
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

    public String getDevicetagid() {
        return devicetagid;
    }

    public void setDevicetagid(String devicetagid) {
        this.devicetagid = devicetagid;
    }

    public String getH213() {
        return H213;
    }

    public void setH213(String H213) {
        this.H213 = H213;
    }

    public String getH214() {
        return H214;
    }

    public void setH214(String H214) {
        this.H214 = H214;
    }

    public String getH21501() {
        return H21501;
    }

    public void setH21501(String H21501) {
        this.H21501 = H21501;
    }

    public String getH21502() {
        return H21502;
    }

    public void setH21502(String H21502) {
        this.H21502 = H21502;
    }

    public String getH21601() {
        return H21601;
    }

    public void setH21601(String H21601) {
        this.H21601 = H21601;
    }

    public String getH21602() {
        return H21602;
    }

    public void setH21602(String H21602) {
        this.H21602 = H21602;
    }

    public String getH21701() {
        return H21701;
    }

    public void setH21701(String H21701) {
        this.H21701 = H21701;
    }

    public String getH21702() {
        return H21702;
    }

    public void setH21702(String H21702) {
        this.H21702 = H21702;
    }

    public String getJSON() {
        return form_json;
    }

    public void setJSON(String form_json) {
        this.form_json = form_json;
    }

    public Form Sync(JSONObject jsonObject) throws JSONException {

        this.id = jsonObject.getString(FormsTable.COLUMN_ID);
        this.uid = jsonObject.getString(FormsTable.COLUMN_UID);
        this.istatus = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.istatus96x = jsonObject.getString(FormsTable.COLUMN_ISTATUS96x);
        this.endingdatetime = jsonObject.getString(FormsTable.COLUMN_ENDINGDATETIME);
        this.synced = jsonObject.getString(FormsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsTable.COLUMN_APPVERSION);
        this.deviceid = jsonObject.getString(FormsTable.COLUMN_DEVICEID);
        this.devicetagid = jsonObject.getString(FormsTable.COLUMN_DEVICETAGID);
        this.sysdate = jsonObject.getString(FormsTable.COLUMN_SYSDATE);
        this.username = jsonObject.getString(FormsTable.COLUMN_USERNAME);
        this.form_json = jsonObject.getString(FormsTable.COLUMN_JSON);
        this.H213 = jsonObject.getString(FormsTable.COLUMN_H213);
        this.H214 = jsonObject.getString(FormsTable.COLUMN_H214);
        this.H21501 = jsonObject.getString(FormsTable.COLUMN_H21501);
        this.H21502 = jsonObject.getString(FormsTable.COLUMN_H21502);
        this.H21601 = jsonObject.getString(FormsTable.COLUMN_H21601);
        this.H21602 = jsonObject.getString(FormsTable.COLUMN_H21602);
        this.H21701 = jsonObject.getString(FormsTable.COLUMN_H21701);
        this.H21702 = jsonObject.getString(FormsTable.COLUMN_H21702);

        return this;
    }

    public Form Hydrate(Cursor cursor) {

        this.id = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UID));
        this.istatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.istatus96x = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS96x));
        this.endingdatetime = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ENDINGDATETIME));
        this.appversion = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APPVERSION));
        this.deviceid = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
        this.devicetagid = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));
        this.sysdate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYSDATE));
        this.username = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_USERNAME));
        this.form_json = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_JSON));
        this.H213 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_H213));
        this.H214 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_H214));
        this.H21501 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_H21501));
        this.H21502 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_H21502));
        this.H21601 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_H21601));
        this.H21602 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_H21602));
        this.H21701 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_H21701));
        this.H21702 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_H21702));

        return this;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_ID, this.id == null ? JSONObject.NULL : this.id);
        json.put(FormsTable.COLUMN_UID, this.uid == null ? JSONObject.NULL : this.uid);
        json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormsTable.COLUMN_ISTATUS96x, this.istatus96x == null ? JSONObject.NULL : this.istatus96x);
        json.put(FormsTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);
        json.put(FormsTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceid == null ? JSONObject.NULL : this.deviceid);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.devicetagid == null ? JSONObject.NULL : this.devicetagid);
        json.put(FormsTable.COLUMN_SYSDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
        json.put(FormsTable.COLUMN_USERNAME, this.username == null ? JSONObject.NULL : this.username);
        json.put(FormsTable.COLUMN_H213, this.H213 == null ? JSONObject.NULL : this.H213);
        json.put(FormsTable.COLUMN_H214, this.H214 == null ? JSONObject.NULL : this.H214);
        json.put(FormsTable.COLUMN_H21501, this.H21501 == null ? JSONObject.NULL : this.H21501);
        json.put(FormsTable.COLUMN_H21502, this.H21502 == null ? JSONObject.NULL : this.H21502);
        json.put(FormsTable.COLUMN_H21601, this.H21601 == null ? JSONObject.NULL : this.H21601);
        json.put(FormsTable.COLUMN_H21602, this.H21602 == null ? JSONObject.NULL : this.H21602);
        json.put(FormsTable.COLUMN_H21701, this.H21701 == null ? JSONObject.NULL : this.H21701);
        json.put(FormsTable.COLUMN_H21702, this.H21702 == null ? JSONObject.NULL : this.H21702);

        if (!this.form_json.equals("")) {
            json.put(FormsTable.COLUMN_JSON, this.form_json.equals("") ? JSONObject.NULL : new JSONObject(this.form_json));
        }

        return json;
    }
}
