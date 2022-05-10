package xyz.xiaogai.bean;

import java.util.List;

public class Page {
    //当前页
    private int page;
    //每页显示的数量
    private int pageSize;
    //总记录数
    private int total;
    //总页数
    private int totalPage;
    //当前页记录
    private List<User> users;

    public Page() {
    }

    public Page(int page, int total, int totalPage, List<User> users) {
        this.page = page;
        this.total = total;
        this.totalPage = totalPage;
        this.users = users;
    }

    public Page(int page, int pageSize, int total, int totalPage, List<User> users) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
        this.totalPage = totalPage;
        this.users = users;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
