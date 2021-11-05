package edu.aku.wasimabbas.ehsas_evaluation.models;

import android.database.Cursor;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.wasimabbas.ehsas_evaluation.contracts.DistrictsContract;


public class Districts {

    private static final String TAG = "Districts_CONTRACT";
    Long id;
    String code;
    String name;
    String provinceCode;
    String provinceName;
//    String REGION_DSS;

    public Districts() {
        // Default Constructor
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Districts Sync(JSONObject jsonObject) throws JSONException {
        this.code = jsonObject.getString(DistrictsContract.DistrictsTable.COLUMN_CODE);
        this.name = jsonObject.getString(DistrictsContract.DistrictsTable.COLUMN_NAME);
        this.provinceCode = jsonObject.getString(DistrictsContract.DistrictsTable.COLUMN_PROVINCE_CODE);
        this.provinceName = jsonObject.getString(DistrictsContract.DistrictsTable.COLUMN_PROVINCE_NAME);
        return this;

    }

    public Districts Hydrate(Cursor cursor) {
        this.code = cursor.getString(cursor.getColumnIndex(DistrictsContract.DistrictsTable.COLUMN_CODE));
        this.name = cursor.getString(cursor.getColumnIndex(DistrictsContract.DistrictsTable.COLUMN_NAME));
        this.provinceCode = cursor.getString(cursor.getColumnIndex(DistrictsContract.DistrictsTable.COLUMN_PROVINCE_CODE));
        this.provinceName = cursor.getString(cursor.getColumnIndex(DistrictsContract.DistrictsTable.COLUMN_PROVINCE_NAME));
        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(DistrictsContract.DistrictsTable.COLUMN_ID, this.id == null ? JSONObject.NULL : this.id);
        json.put(DistrictsContract.DistrictsTable.COLUMN_CODE, this.code == null ? JSONObject.NULL : this.code);
        json.put(DistrictsContract.DistrictsTable.COLUMN_NAME, this.name == null ? JSONObject.NULL : this.name);
        json.put(DistrictsContract.DistrictsTable.COLUMN_PROVINCE_CODE, this.provinceCode == null ? JSONObject.NULL : this.provinceCode);
        json.put(DistrictsContract.DistrictsTable.COLUMN_PROVINCE_NAME, this.provinceName == null ? JSONObject.NULL : this.provinceName);
        return json;
    }

}