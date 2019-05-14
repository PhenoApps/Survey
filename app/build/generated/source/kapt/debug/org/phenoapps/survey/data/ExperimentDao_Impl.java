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
public final class ExperimentDao_Impl implements ExperimentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfExperiment;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfExperiment;

  public ExperimentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfExperiment = new EntityInsertionAdapter<Experiment>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `experiments`(`id`,`name`,`count`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Experiment value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getCount());
      }
    };
    this.__updateAdapterOfExperiment = new EntityDeletionOrUpdateAdapter<Experiment>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `experiments` SET `id` = ?,`name` = ?,`count` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Experiment value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getCount());
        stmt.bindLong(4, value.getId());
      }
    };
  }

  @Override
  public long insert(final Experiment e) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfExperiment.insertAndReturnId(e);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(final Experiment... e) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfExperiment.handleMultiple(e);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Experiment>> getAll() {
    final String _sql = "SELECT * FROM experiments";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"experiments"}, new Callable<List<Experiment>>() {
      @Override
      public List<Experiment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCount = CursorUtil.getColumnIndexOrThrow(_cursor, "count");
          final List<Experiment> _result = new ArrayList<Experiment>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Experiment _item;
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final int _tmpCount;
            _tmpCount = _cursor.getInt(_cursorIndexOfCount);
            _item = new Experiment(_tmpName,_tmpCount);
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
}
