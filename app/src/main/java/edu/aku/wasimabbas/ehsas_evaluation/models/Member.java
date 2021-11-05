package edu.aku.wasimabbas.ehsas_evaluation.models;

import android.database.Cursor;

import androidx.lifecycle.LiveData;

import edu.aku.wasimabbas.ehsas_evaluation.contracts.MembersContract;

public class Member extends LiveData<Member> {

    private final String projectName = "EHSAS_NASHONUMA";
    // Form Variables

    private String endingdatetime = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";
    private String deviceid = "";
    private String devicetagid = "";
    // Other Variables
    private String id = "";
    private String uid = "";
    private String fuid = "";
    private String sysdate = "";
    private String username = "";
    private String collected = "";

    private String H201 = "";
    private String H202 = "";
    private String H203 = "";
    private String H204 = "";
    private String H20501 = "";
    private String H20502 = "";
    private String H20503 = "";

    private String H20601 = "";
    private String H20602 = "";
    private String H20603 = "";

    private String H20701 = "";
    private String H20702 = "";
    private String H20703 = "";
    private String H20704 = "";
    private String H20796 = "";
    private String H20796x = "";

    private String H208 = "";
    private String H209 = "";
    private String H210 = "";
    private String H211 = "";
    private String H212 = "";
    private String H21296x = "";

    private String E101 = "";
    private String E102 = "";
    private String E103 = "";
    private String E104 = "";
    private String E105 = "";
    private String E106 = "";

    public Member() {
    }

    public String getProjectName() {
        return projectName;
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

    public String getH201() {
        return H201;
    }

    public void setH201(String h201) {
        H201 = h201;
    }

    public String getH202() {
        return H202;
    }

    public void setH202(String h202) {
        H202 = h202;
    }

    public String getH203() {
        return H203;
    }

    public void setH203(String h203) {
        H203 = h203;
    }

    public String getH204() {
        return H204;
    }

    public void setH204(String h204) {
        H204 = h204;
    }

    public String getH20501() {
        return H20501;
    }

    public void setH20501(String h20501) {
        H20501 = h20501;
    }

    public String getH20502() {
        return H20502;
    }

    public void setH20502(String h20502) {
        H20502 = h20502;
    }

    public String getH20503() {
        return H20503;
    }

    public void setH20503(String h20503) {
        H20503 = h20503;
    }

    public String getH20601() {
        return H20601;
    }

    public void setH20601(String h20601) {
        H20601 = h20601;
    }

    public String getH20602() {
        return H20602;
    }

    public void setH20602(String h20602) {
        H20602 = h20602;
    }

    public String getH20603() {
        return H20603;
    }

    public void setH20603(String h20603) {
        H20603 = h20603;
    }

    public String getH20701() {
        return H20701;
    }

    public void setH20701(String h20701) {
        H20701 = h20701;
    }

    public String getH20702() {
        return H20702;
    }

    public void setH20702(String h20702) {
        H20702 = h20702;
    }

    public String getH20703() {
        return H20703;
    }

    public void setH20703(String h20703) {
        H20703 = h20703;
    }

    public String getH20704() {
        return H20704;
    }

    public void setH20704(String h20704) {
        H20704 = h20704;
    }

    public String getH20796() {
        return H20796;
    }

    public void setH20796(String h20796) {
        H20796 = h20796;
    }

    public String getH20796x() {
        return H20796x;
    }

    public void setH20796x(String h20796x) {
        H20796x = h20796x;
    }

    public String getH208() {
        return H208;
    }

    public void setH208(String h208) {
        H208 = h208;
    }

    public String getH209() {
        return H209;
    }

    public void setH209(String h209) {
        H209 = h209;
    }

    public String getH210() {
        return H210;
    }

    public void setH210(String h210) {
        H210 = h210;
    }

    public String getH211() {
        return H211;
    }

    public void setH211(String h211) {
        H211 = h211;
    }

    public String getH212() {
        return H212;
    }

    public void setH212(String h212) {
        H212 = h212;
    }

    public String getH21296x() {
        return H21296x;
    }

    public void setH21296x(String h21296x) {
        H21296x = h21296x;
    }

    public String getCollected() {
        return collected;
    }

    public void setCollected(String collected) {
        this.collected = collected;
    }

    public String getE101() {
        return E101;
    }

    public void setE101(String e101) {
        E101 = e101;
    }

    public String getE102() {
        return E102;
    }

    public void setE102(String e102) {
        E102 = e102;
    }

    public String getE103() {
        return E103;
    }

    public void setE103(String e103) {
        E103 = e103;
    }

    public String getE104() {
        return E104;
    }

    public void setE104(String e104) {
        E104 = e104;
    }

    public String getE105() {
        return E105;
    }

    public void setE105(String e105) {
        E105 = e105;
    }

    public String getE106() {
        return E106;
    }

    public void setE106(String e106) {
        E106 = e106;
    }

    public Member Hydrate(Cursor cursor) {

        this.id = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_UID));
        this.fuid = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_FUID));
        this.appversion = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_APPVERSION));
        this.deviceid = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_DEVICEID));
        this.devicetagid = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_DEVICETAGID));
        this.sysdate = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_SYSDATE));
        this.username = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_USERNAME));
        this.collected = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_COLLECTED));
        this.H201 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H201));
        this.H202 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H202));
        this.H203 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H203));
        this.H204 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H204));
        this.H20501 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H20501));
        this.H20502 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H20502));
        this.H20503 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H20503));
        this.H20601 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H20601));
        this.H20602 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H20602));
        this.H20603 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H20603));
        this.H20701 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H20701));
        this.H20702 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H20702));
        this.H20703 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H20703));
        this.H20704 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H20704));
        this.H20796 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H20796));
        this.H20796x = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H20796x));
        this.H208 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H208));
        this.H209 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H209));
        this.H210 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H210));
        this.H211 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H211));
        this.H212 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H212));
        this.H21296x = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_H21296X));
        this.E101 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_E101));
        this.E102 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_E102));
        this.E103 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_E103));
        this.E104 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_E104));
        this.E105 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_E105));
        this.E106 = cursor.getString(cursor.getColumnIndex(MembersContract.MembersTable.COLUMN_E106));

        return this;
    }

    /*public Member Sync(JSONObject jsonObject) throws JSONException {

        this.id = jsonObject.getString(MembersTable.COLUMN_ID);
        this.uid = jsonObject.getString(MembersTable.COLUMN_UID);
        this.fuid = jsonObject.getString(MembersTable.COLUMN_FUID);
        this.istatus = jsonObject.getString(MembersTable.COLUMN_ISTATUS);
        this.istatus96x = jsonObject.getString(MembersTable.COLUMN_ISTATUS96x);
        this.endingdatetime = jsonObject.getString(MembersTable.COLUMN_ENDINGDATETIME);
        this.synced = jsonObject.getString(MembersTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(MembersTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(MembersTable.COLUMN_APPVERSION);
        this.deviceid = jsonObject.getString(MembersTable.COLUMN_DEVICEID);
        this.devicetagid = jsonObject.getString(MembersTable.COLUMN_DEVICETAGID);
        this.sysdate = jsonObject.getString(MembersTable.COLUMN_SYSDATE);
        this.username = jsonObject.getString(MembersTable.COLUMN_USERNAME);

        this.H201 = jsonObject.getString(MembersTable.COLUMN_H201);
        this.H202 = jsonObject.getString(MembersTable.COLUMN_H202);
        this.H203 = jsonObject.getString(MembersTable.COLUMN_H203);
        this.H204 = jsonObject.getString(MembersTable.COLUMN_H204);
        this.H205 = jsonObject.getString(MembersTable.COLUMN_H205);
        this.H206 = jsonObject.getString(MembersTable.COLUMN_H206);
        this.H207 = jsonObject.getString(MembersTable.COLUMN_H207);
        this.H208 = jsonObject.getString(MembersTable.COLUMN_H208);
        this.H209 = jsonObject.getString(MembersTable.COLUMN_H209);
        this.H210 = jsonObject.getString(MembersTable.COLUMN_H210);
        this.H211 = jsonObject.getString(MembersTable.COLUMN_H211);

        return this;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(MembersTable.COLUMN_ID, this.id == null ? JSONObject.NULL : this.id);
        json.put(MembersTable.COLUMN_UID, this.uid == null ? JSONObject.NULL : this.uid);
        json.put(MembersTable.COLUMN_FUID, this.fuid == null ? JSONObject.NULL : this.fuid);
        json.put(MembersTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(MembersTable.COLUMN_ISTATUS96x, this.istatus96x == null ? JSONObject.NULL : this.istatus96x);
        json.put(MembersTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);
        //json.put(MembersTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        //json.put(MembersTable.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);
        json.put(MembersTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);
        json.put(MembersTable.COLUMN_DEVICEID, this.deviceid == null ? JSONObject.NULL : this.deviceid);
        json.put(MembersTable.COLUMN_DEVICETAGID, this.devicetagid == null ? JSONObject.NULL : this.devicetagid);
        json.put(MembersTable.COLUMN_SYSDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
        json.put(MembersTable.COLUMN_USERNAME, this.username == null ? JSONObject.NULL : this.username);

        json.put(MembersContract.MembersTable.COLUMN_H201, this.H201 == null ? JSONObject.NULL : this.H201);
        json.put(MembersContract.MembersTable.COLUMN_H202, this.H202 == null ? JSONObject.NULL : this.H202);
        json.put(MembersContract.MembersTable.COLUMN_H203, this.H203 == null ? JSONObject.NULL : this.H203);
        json.put(MembersContract.MembersTable.COLUMN_H204, this.H204 == null ? JSONObject.NULL : this.H204);
        json.put(MembersContract.MembersTable.COLUMN_H205, this.H205 == null ? JSONObject.NULL : this.H205);
        json.put(MembersContract.MembersTable.COLUMN_H206, this.H206 == null ? JSONObject.NULL : this.H206);
        json.put(MembersContract.MembersTable.COLUMN_H207, this.H207 == null ? JSONObject.NULL : this.H207);
        json.put(MembersContract.MembersTable.COLUMN_H208, this.H208 == null ? JSONObject.NULL : this.H208);
        json.put(MembersContract.MembersTable.COLUMN_H209, this.H209 == null ? JSONObject.NULL : this.H209);
        json.put(MembersContract.MembersTable.COLUMN_H210, this.H210 == null ? JSONObject.NULL : this.H210);
        json.put(MembersContract.MembersTable.COLUMN_H211, this.H211 == null ? JSONObject.NULL : this.H211);

        return json;
    }*/
}
