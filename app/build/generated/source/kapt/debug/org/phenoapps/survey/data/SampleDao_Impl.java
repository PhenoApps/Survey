package org.phenoapps.survey.data;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public final class SampleDao_Impl implements SampleDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfSample;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfSample;

  public SampleDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSample = new EntityInsertionAdapter<Sample>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `samples`(`id`,`eid`,`name`,`latitude`,`longitude`,`person`,`plot`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Sample value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getEid());
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        stmt.bindDouble(4, value.getLatitude());
        stmt.bindDouble(5, value.getLongitude());
        if (value.getPerson() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPerson());
        }
        if (value.getPlot() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPlot());
        }
      }
    };
    this.__updateAdapterOfSample = new EntityDeletionOrUpdateAdapter<Sample>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `samples` SET `id` = ?,`eid` = ?,`name` = ?,`latitude` = ?,`longitude` = ?,`person` = ?,`plot` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Sample value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getEid());
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        stmt.bindDouble(4, value.getLatitude());
        stmt.bindDouble(5, value.getLongitude());
        if (value.getPerson() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPerson());
        }
        if (value.getPlot() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPlot());
        }
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public long insert(final Sample s) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfSample.insertAndReturnId(s);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateSamples(final Sample... s) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfSample.handleMultiple(s);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Sample>> getAll(final int eid) {
    final String _sql = "SELECT * FROM samples WHERE ? = eid";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, eid);
    return __db.getInvalidationTracker().createLiveData(new String[]{"samples"}, new Callable<List<Sample>>() {
      @Override
      public List<Sample> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEid = CursorUtil.getColumnIndexOrThrow(_cursor, "eid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfPerson = CursorUtil.getColumnIndexOrThrow(_cursor, "person");
          final int _cursorIndexOfPlot = CursorUtil.getColumnIndexOrThrow(_cursor, "plot");
          final List<Sample> _result = new ArrayList<Sample>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Sample _item;
            final int _tmpEid;
            _tmpEid = _cursor.getInt(_cursorIndexOfEid);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpPerson;
            _tmpPerson = _cursor.getString(_cursorIndexOfPerson);
            final String _tmpPlot;
            _tmpPlot = _cursor.getString(_cursorIndexOfPlot);
            _item = new Sample(_tmpEid,_tmpName,_tmpLatitude,_tmpLongitude,_tmpPerson,_tmpPlot);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Sample>> getPlot(final int eid, final String plot) {
    final String _sql = "SELECT * from samples WHERE ? = eid and plot = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, eid);
    _argIndex = 2;
    if (plot == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, plot);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"samples"}, new Callable<List<Sample>>() {
      @Override
      public List<Sample> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEid = CursorUtil.getColumnIndexOrThrow(_cursor, "eid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfPerson = CursorUtil.getColumnIndexOrThrow(_cursor, "person");
          final int _cursorIndexOfPlot = CursorUtil.getColumnIndexOrThrow(_cursor, "plot");
          final List<Sample> _result = new ArrayList<Sample>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Sample _item;
            final int _tmpEid;
            _tmpEid = _cursor.getInt(_cursorIndexOfEid);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpPerson;
            _tmpPerson = _cursor.getString(_cursorIndexOfPerson);
            final String _tmpPlot;
            _tmpPlot = _cursor.getString(_cursorIndexOfPlot);
            _item = new Sample(_tmpEid,_tmpName,_tmpLatitude,_tmpLongitude,_tmpPerson,_tmpPlot);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<String>> getPlotNames(final int eid) {
    final String _sql = "SELECT plot from samples WHERE ? = eid";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, eid);
    return __db.getInvalidationTracker().createLiveData(new String[]{"samples"}, new Callable<List<String>>() {
      @Override
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final String _item;
            _item = _cursor.getString(0);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
