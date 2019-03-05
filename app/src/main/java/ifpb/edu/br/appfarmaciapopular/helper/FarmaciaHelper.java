package ifpb.edu.br.appfarmaciapopular.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import ifpb.edu.br.appfarmaciapopular.model.Farmacia;

public class FarmaciaHelper extends SQLiteOpenHelper {

    private static final String ID = "id";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String DDD = "ddd";
    private static final String TELEFONE = "telefone";
    private static final String CEP = "cep";
    private static final String BAIRRO = "bairro";
    private static final String ENDERECO = "endereco";
    private static final String NOME = "nome";
    private static final String CIDADE = "cidade";
    private static final String UF = "uf";

    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "FARMACIA_POPULAR";
    private static final String DATABASE_NAME = "farmacia_popular.db";

    private static final String CREATE_TABLE = new StringBuilder("CREATE TABLE IF NOT EXISTS ").append(TABLE_NAME)
            .append("(")
            .append(ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
            .append(LATITUDE).append(" TEXT, ")
            .append(LONGITUDE).append(" TEXT, ")
            .append(DDD).append(" TEXT, ")
            .append(TELEFONE).append(" TEXT, ")
            .append(CEP).append(" TEXT, ")
            .append(BAIRRO).append(" TEXT, ")
            .append(ENDERECO).append(" TEXT, ")
            .append(NOME).append(" TEXT, ")
            .append(CIDADE).append(" TEXT, ")
            .append(UF).append(" TEXT")
            .append(")")
            .toString();

    private static final String DROP_TABLE = new StringBuilder("DROP TABLE IF EXISTS ").append(TABLE_NAME)
            .toString();

    public FarmaciaHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void clearFarmacias() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(DROP_TABLE);
        db.execSQL(CREATE_TABLE);
    }

    public Boolean insertFarmacia(Farmacia farmacia) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(LATITUDE, farmacia.getLatitude());
        contentValues.put(LONGITUDE, farmacia.getLongitude());
        contentValues.put(DDD, farmacia.getDdd());
        contentValues.put(TELEFONE, farmacia.getTelefone());
        contentValues.put(CEP, farmacia.getCep());
        contentValues.put(BAIRRO, farmacia.getBairro());
        contentValues.put(ENDERECO, farmacia.getEndereco());
        contentValues.put(NOME, farmacia.getNome());
        contentValues.put(CIDADE, farmacia.getCidade());
        contentValues.put(UF, farmacia.getUf());

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        }

        return true;
    }

    public Integer countFarmacias() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME, null);
        cursor.moveToFirst();
        Integer count = cursor.getInt(0);
        cursor.close();
        return count;
    }
}
