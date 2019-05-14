package org.phenoapps.survey.data;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unchecked")
public final class SurveyDatabase_Impl extends SurveyDatabase {
  private volatile ExperimentDao _experimentDao;

  private volatile SampleDao _sampleDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `experiments` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `count` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `samples` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `eid` INTEGER NOT NULL, `name` TEXT NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `person` TEXT NOT NULL, `plot` TEXT NOT NULL, FOREIGN KEY(`eid`) REFERENCES `experiments`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"c2459ccc15b7d319b0a4419f85ba5350\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `experiments`");
        _db.execSQL("DROP TABLE IF EXISTS `samples`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsExperiments = new HashMap<String, TableInfo.Column>(3);
        _columnsExperiments.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsExperiments.put("name", new TableInfo.Column("name", "TEXT", true, 0));
        _columnsExperiments.put("count", new TableInfo.Column("count", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExperiments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExperiments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExperiments = new TableInfo("experiments", _columnsExperiments, _foreignKeysExperiments, _indicesExperiments);
        final TableInfo _existingExperiments = TableInfo.read(_db, "experiments");
        if (! _infoExperiments.equals(_existingExperiments)) {
          throw new IllegalStateException("Migration didn't properly handle experiments(org.phenoapps.survey.data.Experiment).\n"
                  + " Expected:\n" + _infoExperiments + "\n"
                  + " Found:\n" + _existingExperiments);
        }
        final HashMap<String, TableInfo.Column> _columnsSamples = new HashMap<String, TableInfo.Column>(7);
        _columnsSamples.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsSamples.put("eid", new TableInfo.Column("eid", "INTEGER", true, 0));
        _columnsSamples.put("name", new TableInfo.Column("name", "TEXT", true, 0));
        _columnsSamples.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0));
        _columnsSamples.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0));
        _columnsSamples.put("person", new TableInfo.Column("person", "TEXT", true, 0));
        _columnsSamples.put("plot", new TableInfo.Column("plot", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSamples = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysSamples.add(new TableInfo.ForeignKey("experiments", "CASCADE", "NO ACTION",Arrays.asList("eid"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesSamples = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSamples = new TableInfo("samples", _columnsSamples, _foreignKeysSamples, _indicesSamples);
        final TableInfo _existingSamples = TableInfo.read(_db, "samples");
        if (! _infoSamples.equals(_existingSamples)) {
          throw new IllegalStateException("Migration didn't properly handle samples(org.phenoapps.survey.data.Sample).\n"
                  + " Expected:\n" + _infoSamples + "\n"
                  + " Found:\n" + _existingSamples);
        }
      }
    }, "c2459ccc15b7d319b0a4419f85ba5350", "7ff8602fda71def1ed0372d5e9e13c3f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "experiments","samples");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `experiments`");
      _db.execSQL("DELETE FROM `samples`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public ExperimentDao experimentDao() {
    if (_experimentDao != null) {
      return _experimentDao;
    } else {
      synchronized(this) {
        if(_experimentDao == null) {
          _experimentDao = new ExperimentDao_Impl(this);
        }
        return _experimentDao;
      }
    }
  }

  @Override
  public SampleDao sampleDao() {
    if (_sampleDao != null) {
      return _sampleDao;
    } else {
      synchronized(this) {
        if(_sampleDao == null) {
          _sampleDao = new SampleDao_Impl(this);
        }
        return _sampleDao;
      }
    }
  }
}
