import java.util.ArrayList;

class QueryBuilder {
    String table;
    StringBuilder select = new StringBuilder();
    StringBuilder join = new StringBuilder();
    StringBuilder where = new StringBuilder();
    StringBuilder order = new StringBuilder();
    int limit = -1;

    QueryBuilder(String table) {
        this.table = table;
    }

    void addSelectColumn(String column) {
        if (select.length() > 0) select.append(", ");
        select.append(column);
    }

    void addWhereCondition(String condition, String operator) {
        if (where.length() == 0) {
            where.append(condition);
        } else {
            where.append(" ").append(operator).append(" ").append(condition);
        }
    }

    void addJoin(String table, String condition) {
        join.append(" JOIN ").append(table).append(" ON ").append(condition);
    }

    void addOrderBy(String column, String direction) {
        if (order.length() > 0) order.append(", ");
        order.append(column).append(" ").append(direction);
    }

    void setLimit(int limit) {
        this.limit = limit;
    }

    String build() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ").append(select);
        query.append(" FROM ").append(table);
        query.append(join);
        if (where.length() > 0) query.append(" WHERE ").append(where);
        if (order.length() > 0) query.append(" ORDER BY ").append(order);
        if (limit >= 0) query.append(" LIMIT ").append(limit);
        return query.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        QueryBuilder qb = new QueryBuilder("Employees");

        qb.addSelectColumn("Employees.id");
        qb.addSelectColumn("Employees.name");
        qb.addSelectColumn("Employees.salary");
        qb.addSelectColumn("Departments.dept_name");
        qb.addSelectColumn("Employees.hire_date");

        qb.addJoin("Departments", "Employees.dept_id = Departments.id");

        qb.addWhereCondition("Employees.salary > 50000", "AND");
        qb.addWhereCondition("Departments.location = 'NY'", "AND");
        qb.addWhereCondition("Employees.status = 'Active'", "OR");

        qb.addOrderBy("Employees.name", "ASC");
        qb.addOrderBy("Employees.salary", "DESC");

        qb.setLimit(10);

        String query = qb.build();

        System.out.println(query);
        System.out.println(query.length());
    }
}
