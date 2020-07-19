
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/registercss.css">
    <script>
        // 检查form表单
        checkForm=function(){
            if(checkUsername()&&checkPassword()){
                return true;
            }else{
                return false;
            }
        }

        // 检查用户名
        checkUsername=function(){
            var usernamereg = /^[a-zA-Z0-9]{6,10}$/;
            var usernameValue = document.getElementById("username").value;
            var usernameStrong = document.getElementById('usernameStrong');

            if(usernamereg.test(usernameValue)){
                usernameStrong.style.color="green";
                usernameStrong.innerHTML='√';
                return true;
            }else{
                usernameStrong.style.color='red';
                usernameStrong.innerHTML='×你输入格式不正确';
                return false;
            }

        }

        // 检查密码格式
        checkPassword = function(){
            var passwordReg = /^[a-zA-Z0-9_$]{8,12}$/;
            var passwordValue = document.getElementById('password').value;
            var passwordStrong = document.getElementById('passwordStrong');
            if(passwordReg.test(passwordValue)){
                passwordStrong.innerHTML='√';
                passwordStrong.style.color='green';
                return true;
            }else{
                passwordStrong.innerHTML='你输入的密码不合法';
                passwordStrong.style.color = 'red';
                return false;
            }
        }

    </script>
</head>
<body>

<div>
    <!--第一行：存放logo信息   嵌套一个一行三列的表格 -->
    <tr>
        <td>
            <table   width="100%" >
                <tr>
                    <td>
                        <img src="../img/logo.jpg" />
                    </td>
                    <td >
                        <img src="../img/img5.jpg" id="imgId5"/>&nbsp;&nbsp;
                        <img src="../img/img6.jpg" />&nbsp;&nbsp;
                        <img src="../img/img7.jpg" />&nbsp;&nbsp;
                        <img src="../img/img4.jpg" />
                    </td>
                    <td align="center">
                        <a href="${pageContext.request.contextPath}/JSP/login.jsp"><font color="#337AB7">登录</font></a>&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/JSP/register.jsp"><font color="#337AB7">注册</font></a>&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/JSP/cart.jsp"><font color="#337AB7">购物车</font></a>
                    </td>
                </tr>
            </table>
        </td>
    </tr>

</div>

<div style="width:100%;background-image:url('../image/registerBack.jpg'); background-size: cover;">


    <form action="${pageContext.request.contextPath}/UserServlet?method=register" class="bootstrap-frm" method="post" onsubmit= "return checkForm()">

        <h1>会员注册
            <span>USER REGISTER.</span>
        </h1>
        <label>
            <span>用户名</span>
            <input id="username" type="text" name="username" onblur="checkUsername()"/><strong id="usernameStrong"></strong>
        </label>

        <label>
            <span>密  码</span>
            <input type="password" id="password" name="password" onblur="checkPassword()"  placeholder="请输入密码"/><strong id="passwordStrong"></strong>
        </label>

        <label>
            <span>确认密码</span>
            <input type="password" id="repassword" name="repassword" placeholder="请输入确认密码"/>
        </label>

        <label>
            <span>Email</span>
            <input type="email" id="email" name="email" placeholder="Email"/>
        </label>

        <label>
            <span>姓  名</span>
            <input type="text" id="name" name="name" placeholder="请输入姓名"/>
        </label>




        <label>
            <span>性  别</span><select name="sex">
            <option name = "sex" value="男">男</option>
            <option name = "sex" value="女">女</option>
        </select>
        </label>

        <label>
            <span>出生日期</span>
            <input id="birthday" type="text" name="birthday" placeholder="年/月/日" />
        </label>


        <label>
            <span>&nbsp;</span>
            <input type="submit"  width="100" value="注册" name="submit" border="0"
                   style="background: url('../image/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
        </label>
    </form>

</div>

<div align="center">

    <!--第八行：存放友情链接-->
    <tr>
        <td>
            <p align="center">
                <a href=""><font color="#337AB7">关于我们</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">联系我们</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">联系客服</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">合作招商</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">商家帮助</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">营销中心</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">手机帮助</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">销售联盟</font></a>&nbsp;&nbsp;
            </p>
        </td>
    </tr>
    <!--第九行：存放版权信息-->
    <tr>
        <td align="center">
            © 2005-2020 东易买 版权所有，并保留所有权利
        </td>
    </tr>

</div>

</body>


</html>
