<%--
  Created by IntelliJ IDEA.
  User: WJX
  Date: 2022/4/13
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" buffer="none" %>
<%@ page import="xyz.xiaogai.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="xyz.xiaogai.bean.Page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/bootstrap.css">
    <script src="static/js/jquery-3.6.0.js"></script>
    <script src="static/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <script src="static/js/list-style.js"></script>
    <title>ShowList</title>
</head>

<body>
<style>
    #main {
        width: 60%;
        /*background-color: #f5f5f5;*/
        margin: 100px auto 0 auto;
        text-align: center;
    }
</style>
<script>
    // $(function () {
    //     $('#searchUserBtn').click(function () {
    //         let username = $('#searchUserInp').val();
    //         console.log(username);
    //     });
    // })
</script>
<div>
    <div id="main">
        <div class="input-group mb-3">
            <input id="searchUserInp" type="text" class="form-control" placeholder="username" aria-label="username"
                   aria-describedby="searchUserBtn">
            <div class="input-group-append">
                <a class="btn btn-outline-secondary" type="button" id="searchUserBtn" href=""><i
                        class="bi bi-search"></i></a>
            </div>
        </div>
        <!--
            table-bordered 表格边框
            table-striped 表格条纹
            table-hover 表格鼠标悬停
            table-dark 表格黑色
            table-sm 表格小
            table-responsive 表格自适应
         -->
        <table class="table table-sm table-hover">
            <thead>
            <tr class="btn-secondary">
                <th scope="col"><input type="checkbox" name="" id="checkAll">全选</th>
                <th scope="col">id</th>
                <th scope="col">email</th>
                <th scope="col">username</th>
                <th scope="col">password</th>
                <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="num" value="${0}"/>
            <c:forEach var="user" items="${requestScope.page.users}">

                <tr>
                    <th scope="col"><input name="checkbox1" type="checkbox"></th>
                    <td>${user.id}</td>
                    <td>${user.email}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>
                            <%-- <c:url value="/ListServlet?indexPage=${requestScope.indexPage}&editUser=${num=num+1}"/>--%>
                            <%--${num=num+1}--%>
                        <button id="editUserBtn" class="btn btn btn-outline-primary btn-sm editbtn" number="${num=num+1}"
                                data-toggle="modal" data-target="#editUserModal">编辑
                        </button>
                        <a class="btn btn btn-outline-danger btn-sm"
                           href="<c:url value="/ListServlet?indexPage=${requestScope.indexPage}&userId=${user.id}"/>">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a id="deleteUser" class="invisible btn btn-danger btn-lg float-right"
           href="<c:url value="/ListServlet?indexPage=${requestScope.indexPage}&deleteAll=1"/>">删除全部</a>
        <button id="addUserBtn" class="btn btn-primary btn-lg float-left" data-toggle="modal"
                data-target="#addUserModal">添加
        </button>

        <!-- addUserModal -->
        <div class="modal fade" id="addUserModal" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="text-center modal-title" id="exampleModalLabel">添加用户</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body text-left">
                        <%--                        <form action="<c:url value="/ListServlet?indexPage=${requestScope.indexPage}&addUser=1"/>">--%>
                        <form action="ListServlet">
                            <div class="form-group">
                                <label for="addUsername">username</label>
                                <input type="text" class="form-control" name="addUsername" id="addUsername">
                            </div>
                            <div class="form-group">
                                <label for="addEmail">Email address</label>
                                <input type="email" class="form-control" name="addEmail" id="addEmail"
                                       aria-describedby="emailHelp">
                                <small id="emailHelp" class="form-text text-muted">We'll never share your email with
                                    anyone else.</small>
                            </div>
                            <div class="form-group">
                                <label for="addPassword">Password</label>
                                <input type="password" class="form-control" name="addPassword" id="addPassword">
                            </div>
                            <input class="invisible" name="addUser" value="1">
                            <!-- <button type="submit" class="btn btn-primary">Submit</button> -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                                <button type="submit" class="btn btn-primary">添加用户</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <!-- editUserModal -->
        <div class="modal fade" id="editUserModal" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="text-center modal-title" id="exampleModalLabel1">编辑用户</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body text-left">
                        <form action="ListServlet">
                            <div class="form-group">
                                <label for="editUsername">New Username</label>
                                <input type="text" class="form-control" name="editUsername" id="editUsername"
                                       placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="editEmail">New Email address</label>
                                <input type="email" class="form-control" name="editEmail" id="editEmail"
                                       aria-describedby="emailHelp">
                                <small id="emailHelp1" class="form-text text-muted">We'll never share your email with
                                    anyone else.</small>
                            </div>
                            <div class="form-group">
                                <label for="editPassword">New Password</label>
                                <input type="text" class="form-control" name="editPassword" id="editPassword">
                            </div>
                            <input id="editUser" class="invisible" name="editUser">
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                                <button type="submit" class="btn btn-primary">编辑用户</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <br><br>
    </div>


    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <!--
                disabled 不可用
                active 当前页
             -->
            <c:set var="leftdisabled" value="${requestScope.indexPage==1?'disabled':''}"/>
            <c:set var="rightdisabled" value="${requestScope.indexPage==requestScope.page.totalPage?'disabled':''}"/>
            <li class="page-item ${leftdisabled}">
                <a class="page-link" href="<c:url value="/ListServlet?indexPage=${requestScope.indexPage-1}"/>"><span
                        aria-hidden="true">&laquo;</span></a>
            </li>
            <c:forEach var="i" begin="1" end="${requestScope.page.totalPage}">
                <c:if test="${i==requestScope.indexPage}">
                    <li class="page-item active"><a class="page-link" href="#">${i}</a></li>
                </c:if>
                <c:if test="${i!=requestScope.indexPage}">
                    <li class="page-item"><a class="page-link"
                                             href="<c:url value="/ListServlet?indexPage=${i}"/>">${i}</a></li>
                </c:if>
            </c:forEach>
            <li class="page-item ${rightdisabled}">
                <a class="page-link" href="<c:url value="/ListServlet?indexPage=${requestScope.indexPage+1}"/>"><span
                        aria-hidden="true">&raquo;</span></a>
            </li>
        </ul>
    </nav>
</div>

<%--<c:if test="${sessionScope.page.users.size()>0}">--%>
<%--    <button type="button" class="btn btn-outline-danger btn-sm" id="deleteAll">删除所选</button>--%>
<%--</c:if>--%>

</body>

</html>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--    <!-- 新 Bootstrap4 核心 CSS 文件 -->--%>
<%--    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">--%>

<%--    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->--%>
<%--    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>--%>

<%--    <!-- bootstrap.bundle.min.js 用于弹窗、提示、下拉菜单，包含了 popper.min.js -->--%>
<%--    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>--%>

<%--    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->--%>
<%--    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>

<%--<div>--%>
<%--<table class="table">--%>
<%--    <caption>List of users</caption>--%>
<%--    <thead>--%>
<%--    <tr class="bg-primary">--%>
<%--        <th scope="col">id</th>--%>
<%--        <th scope="col">username</th>--%>
<%--        <th scope="col">password</th>--%>
<%--        <th scope="col">email</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach var="user" items="${users}">--%>
<%--        <tr>--%>
<%--            <th scope="row">${user.id}</th>--%>
<%--            <td>${user.username}</td>--%>
<%--            <td>${user.password}</td>--%>
<%--            <td>${user.email}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>

<%--&lt;%&ndash;    <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <th scope="row">1</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td>Mark</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td>Otto</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td>@mdo</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </tr>&ndash;%&gt;--%>

<%--    </tbody>--%>
<%--</table>--%>
<%--        </div>--%>
<%--<h1>${users}</h1>--%>

<%--&lt;%&ndash;<c:forEach var="user" items="${sessionScope.users}">&ndash;%&gt;--%>
<%--&lt;%&ndash;    ${user.username}&ndash;%&gt;--%>
<%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
<%--</body>--%>
<%--</html>--%>
