package edu.aku.wasimabbas.ehsas_evaluation.models;

import android.database.Cursor;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.wasimabbas.ehsas_evaluation.contracts.ClustersContract;


public class Clusters {

    private static final String TAG = "Clusters_CONTRACT";
    Long id;
    String clusterNo;
    String provinceCode;
    String provinceName;
    String districtCode;
    String districtName;
    String tehsil;
    String unionCouncil;
    String city;
    // String REGION_DSS;

    public Clusters() {
        // Default Constructor
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClusterNo() {
        return clusterNo;
    }

    public void setClusterNo(String clusterNo) {
        this.clusterNo = clusterNo;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getTehsil() {
        return tehsil;
    }

    public void setTehsil(String tehsil) {
        this.tehsil = tehsil;
    }

    public String getUnionCouncil() {
        return unionCouncil;
    }

    public void setUnionCouncil(String unionCouncil) {
        this.unionCouncil = unionCouncil;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Clusters Sync(JSONObject jsonObject) throws JSONException {
        this.clusterNo = jsonObject.getString(ClustersContract.ClustersTable.COLUMN_CLUSTER_NO);
        this.provinceCode = jsonObject.getString(ClustersContract.ClustersTable.COLUMN_PROVINCE_CODE);
        this.provinceName = jsonObject.getString(ClustersContract.ClustersTable.COLUMN_PROVINCE_NAME);
        this.districtCode = jsonObject.getString(ClustersContract.ClustersTable.COLUMN_DISTRICT_CODE);
        this.districtName = jsonObject.getString(ClustersContract.ClustersTable.COLUMN_DISTRICT_NAME);
        this.tehsil = jsonObject.getString(ClustersContract.ClustersTable.COLUMN_TEHSIL);
        this.unionCouncil = jsonObject.getString(ClustersContract.ClustersTable.COLUMN_UNION_COUNCIL);
        this.city = jsonObject.getString(ClustersContract.ClustersTable.COLUMN_CITY);
        return this;

    }

    public Clusters Hydrate(Cursor cursor) {
        this.clusterNo = cursor.getString(cursor.getColumnIndex(ClustersContract.ClustersTable.COLUMN_CLUSTER_NO));
        this.provinceCode = cursor.getString(cursor.getColumnIndex(ClustersContract.ClustersTable.COLUMN_PROVINCE_CODE));
        this.provinceName = cursor.getString(cursor.getColumnIndex(ClustersContract.ClustersTable.COLUMN_PROVINCE_NAME));
        this.districtCode = cursor.getString(cursor.getColumnIndex(ClustersContract.ClustersTable.COLUMN_DISTRICT_CODE));
        this.districtName = cursor.getString(cursor.getColumnIndex(ClustersContract.ClustersTable.COLUMN_DISTRICT_NAME));
        this.tehsil = cursor.getString(cursor.getColumnIndex(ClustersContract.ClustersTable.COLUMN_TEHSIL));
        this.unionCouncil = cursor.getString(cursor.getColumnIndex(ClustersContract.ClustersTable.COLUMN_UNION_COUNCIL));
        this.city = cursor.getString(cursor.getColumnIndex(ClustersContract.ClustersTable.COLUMN_CITY));
        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(ClustersContract.ClustersTable.COLUMN_ID, this.id == null ? JSONObject.NULL : this.id);
        json.put(ClustersContract.ClustersTable.COLUMN_CLUSTER_NO, this.clusterNo == null ? JSONObject.NULL : this.clusterNo);
        json.put(ClustersContract.ClustersTable.COLUMN_PROVINCE_CODE, this.provinceCode == null ? JSONObject.NULL : this.provinceCode);
        json.put(ClustersContract.ClustersTable.COLUMN_PROVINCE_NAME, this.provinceName == null ? JSONObject.NULL : this.provinceName);
        json.put(ClustersContract.ClustersTable.COLUMN_DISTRICT_CODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
        json.put(ClustersContract.ClustersTable.COLUMN_DISTRICT_NAME, this.districtName == null ? JSONObject.NULL : this.districtName);
        json.put(ClustersContract.ClustersTable.COLUMN_TEHSIL, this.tehsil == null ? JSONObject.NULL : this.tehsil);
        json.put(ClustersContract.ClustersTable.COLUMN_UNION_COUNCIL, this.unionCouncil == null ? JSONObject.NULL : this.unionCouncil);
        json.put(ClustersContract.ClustersTable.COLUMN_CITY, this.city == null ? JSONObject.NULL : this.city);
        return json;
    }

}