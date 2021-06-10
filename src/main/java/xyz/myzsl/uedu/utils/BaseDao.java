package xyz.myzsl.uedu.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2021-05-22 11:10:48
 */
public class BaseDao<T> {
    private final QueryRunner queryRunner = new QueryRunner();
    private final Class<T> type;

    public BaseDao() {
        Class<? extends BaseDao> aClass = this.getClass();
        ParameterizedType genericSuperclass = (ParameterizedType) aClass.getGenericSuperclass();
        Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
        this.type = (Class<T>) actualTypeArguments[0];
    }

    /**
     * 数据更新
     *
     * @param sql     sql语句
     * @param objects 参数
     * @return 操作影响的行数
     */
    public int update(String sql, Object... objects) {
        Connection connection = DruidJdbcUtils.getConnection();
        int update = 0;
        try {
            update = queryRunner.update(connection, sql, objects);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidJdbcUtils.closeConnection(connection);
        }

        return update;
    }

    /**
     * 查询一条数据
     *
     * @param sql     sql语句
     * @param objects 参数
     * @return T对象
     */
    public T queryOne(String sql, Object... objects) {
        Connection connection = DruidJdbcUtils.getConnection();
        BeanHandler<T> beanHandler = new BeanHandler<>(type);
        T t = null;
        try {
            t = queryRunner.query(connection, sql, beanHandler, objects);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidJdbcUtils.closeConnection(connection);
        }
        return t;
    }

    /**
     * 查询多行数据
     *
     * @param sql sql语句
     * @return List<T>
     */
    public List<T> queryList(String sql) {
        Connection connection = DruidJdbcUtils.getConnection();
        BeanListHandler<T> beanListHandler = new BeanListHandler<>(type);
        List<T> ts = null;
        try {
            ts = queryRunner.query(connection, sql, beanListHandler);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidJdbcUtils.closeConnection(connection);
        }
        return ts;
    }


    public List<T> queryListWithLimit(String sql, Object... objects) {
        Connection connection = DruidJdbcUtils.getConnection();
        BeanListHandler<T> beanListHandler = new BeanListHandler<>(type);
        List<T> ts = null;
        try {
            ts = queryRunner.query(connection, sql, beanListHandler, objects);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidJdbcUtils.closeConnection(connection);
        }
        return ts;
    }

    /**
     * 统计表中数据行数
     *
     * @param sql     sql语句
     * @param objects 参数
     * @return 个数
     */
    public Long queryCount(String sql, Object... objects) {
        Connection connection = DruidJdbcUtils.getConnection();
        ScalarHandler<Long> scalarHandler = new ScalarHandler<>();
        Long query = null;
        try {
            query = queryRunner.query(connection, sql, scalarHandler, objects);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidJdbcUtils.closeConnection(connection);
        }
        return query;

    }
}
