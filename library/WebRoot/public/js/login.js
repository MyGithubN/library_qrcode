$(function () {
    $('#login_submit').click(function () {
        if (!validLogin()) {
            return;
        }
        $("form").submit();
    });

    var alert = $('.alert');
    var formWidth = $('.bootstrap-admin-login-form').innerWidth();
    var alertPadding = parseInt($('.alert').css('padding'));
    if (isNaN(alertPadding)) {
        alertPadding = parseInt($(alert).css('padding-left'));
    }
    $('.alert').width(formWidth - 2 * alertPadding);
});

function validLogin() {
    var flag = true;

    var username = $.trim($("#username").val());
    if (username == "") {
        $('#username').parent().addClass("has-error");
        $('#username').next().text("请输入账号");
        $("#username").next().show();
        flag = false;
    } else if (username.length > 20) {
        $("#username").parent().addClass("has-error");
        $("#username").next().text("账号长度不能大于20");
        $("#username").next().show();
        flag = false;
    } else {
        $('#username').parent().removeClass("has-error");
        $('#username').next().text("");
        $("#username").next().hide();
    }

    var password = $.trim($("#password").val());
    if (password == "") {
        $('#password').parent().addClass("has-error");
        $('#password').next().text("请输入密码");
        $("#password").next().show();
        flag = false;
    } else if (password.length > 20) {
        $("#password").parent().addClass("has-error");
        $("#password").next().text("密码长度不能大于20");
        $("#password").next().show();
        flag = false;
    } else {
        $('#password').parent().removeClass("has-error");
        $('#password').next().text("");
        $("#password").next().hide();
    }
    return flag;
}

function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}



$(function () {
    $('#search_submit').click(function () {
        if (!validLogin2()) {
            return;
        }
        $("form").submit();
    });

    var alert = $('.alert');
    var formWidth = $('.bootstrap-admin-login-form').innerWidth();
    var alertPadding = parseInt($('.alert').css('padding'));
    if (isNaN(alertPadding)) {
        alertPadding = parseInt($(alert).css('padding-left'));
    }
    $('.alert').width(formWidth - 2 * alertPadding);
});

function validLogin2() {
    var flag = true;
    
    var username = $.trim($("#search").val());
    if (username == "") {
        $('#tab').text("请输入内容");
        flag = false;
    } else if (username.length > 20) {
        $("#tab").text("长度不能大于20");
        flag = false;
    } else {
        $('#tab').text("");
    }
    return flag;
}

$(function () {
    $('#submit_register').click(function () {
        if (!validLogin3()) {
            return;
        }
        $("form").submit();
    });

    var alert = $('.alert');
    var formWidth = $('.bootstrap-admin-login-form').innerWidth();
    var alertPadding = parseInt($('.alert').css('padding'));
    if (isNaN(alertPadding)) {
        alertPadding = parseInt($(alert).css('padding-left'));
    }
    $('.alert').width(formWidth - 2 * alertPadding);
});

function validLogin3() {
    var flag = true;
    
    var sname = $.trim($("#sname").val());
    if (sname == "") {
        $('#sname').parent().addClass("has-error");
        $('#sname').next().text("请输入姓名");
        $("#sname").next().show();
        flag = false;
    } else if (sname.length > 10) {
        $("#sname").parent().addClass("has-error");
        $("#sname").next().text("长度不能大于10");
        $("#sname").next().show();
        flag = false;
    } else {
        $('#sname').parent().removeClass("has-error");
        $('#sname').next().text("");
        $("#sname").next().hide();
    }
    
    var sno = $.trim($("#sno").val());
    if (sno == "") {
        $('#sno').parent().addClass("has-error");
        $('#sno').next().text("请输入学号");
        $("#sno").next().show();
        flag = false;
    } else if (sno.length > 20) {
        $("#sno").parent().addClass("has-error");
        $("#sno").next().text("长度不能大于20");
        $("#sno").next().show();
        flag = false;
    } else {
        $('#sno').parent().removeClass("has-error");
        $('#sno').next().text("");
        $("#sno").next().hide();
    }
    
    var email = $.trim($("#email").val());
    var szReg=/^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
    if (email == "") {
        $('#email').parent().addClass("has-error");
        $('#email').next().text("请输入邮箱");
        $("#email").next().show();
        flag = false;
    } else if (email.length > 30) {
        $("#email").parent().addClass("has-error");
        $("#email").next().text("长度不能大于30");
        $("#email").next().show();
        flag = false;
    } else if (! szReg.test(email)) {
        $("#email").parent().addClass("has-error");
        $("#email").next().text("格式错误");
        $("#email").next().show();
        flag = false;
    }else {
        $('#email').parent().removeClass("has-error");
        $('#email').next().text("");
        $("#email").next().hide();
    }
    
    var phone = $.trim($("#phone").val());
    var szReg= /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/; 
    if (phone == "") {
        $('#phone').parent().addClass("has-error");
        $('#phone').next().text("请输入手机号码");
        $("#phone").next().show();
        flag = false;
    } else if (phone.length > 11) {
        $("#phone").parent().addClass("has-error");
        $("#phone").next().text("长度不能大于11");
        $("#phone").next().show();
        flag = false;
    } else if (! szReg.test(phone)) {
        $("#phone").parent().addClass("has-error");
        $("#phone").next().text("格式错误");
        $("#phone").next().show();
        flag = false;
    }else {
        $('#phone').parent().removeClass("has-error");
        $('#phone').next().text("");
        $("#phone").next().hide();
    }
    
    var password = $.trim($("#password").val());
    var szReg= /^[a-zA-Z]\w{5,19}$/; 
    if (password == "") {
        $('#password').parent().addClass("has-error");
        $('#password').next().text("请输入密码");
        $("#password").next().show();
        flag = false;
    } else if (password.length > 20) {
        $("#password").parent().addClass("has-error");
        $("#password").next().text("长度不能大于20");
        $("#password").next().show();
        flag = false;
    } else if (! szReg.test(password)) {
        $("#password").parent().addClass("has-error");
        $("#password").next().text("格式错误");
        $("#password").next().show();
        flag = false;
    }else {
        $('#password').parent().removeClass("has-error");
        $('#password').next().text("");
        $("#password").next().hide();
    }
    
    var password = $.trim($("#password").val());
    var password2 = $.trim($("#password2").val());
    if (password2 == "") {
        $('#password2').parent().addClass("has-error");
        $('#password2').next().text("请输入确定密码");
        $("#password2").next().show();
        flag = false;
    } else if (password2.length > 20) {
        $("#password2").parent().addClass("has-error");
        $("#password2").next().text("长度不能大于20");
        $("#password2").next().show();
        flag = false;
    } else if (password2 != password) {
        $("#password2").parent().addClass("has-error");
        $("#password2").next().text("两次结果不一致");
        $("#password2").next().show();
        flag = false;
    }else {
        $('#password2').parent().removeClass("has-error");
        $('#password2').next().text("");
        $("#password2").next().hide();
    }
    return flag;
}


    function checkSname() {
    	 var sname = $.trim($("#sname").val());
    	    if (sname == "") {
    	        $('#sname').parent().addClass("has-error");
    	        $('#sname').next().text("请输入姓名");
    	        $("#sname").next().show();
    	        flag = false;
    	    } else if (sname.length > 10) {
    	        $("#sname").parent().addClass("has-error");
    	        $("#sname").next().text("长度不能大于10");
    	        $("#sname").next().show();
    	        flag = false;
    	    } else {
    	        $('#sname').parent().removeClass("has-error");
    	        $('#sname').next().text("");
    	        $("#sname").next().hide();
    	    }
    }
    
    function checkSno() {
    	var sno = $.trim($("#sno").val());
        if (sno == "") {
            $('#sno').parent().addClass("has-error");
            $('#sno').next().text("请输入学号");
            $("#sno").next().show();
            flag = false;
        } else if (sno.length > 20) {
            $("#sno").parent().addClass("has-error");
            $("#sno").next().text("长度不能大于20");
            $("#sno").next().show();
            flag = false;
        } else {
            $('#sno').parent().removeClass("has-error");
            $('#sno').next().text("");
            $("#sno").next().hide();
        }
   }
    
    function checkEmail() {
    	var email = $.trim($("#email").val());
        var szReg=/^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
        if (email == "") {
            $('#email').parent().addClass("has-error");
            $('#email').next().text("请输入邮箱");
            $("#email").next().show();
            flag = false;
        } else if (email.length > 30) {
            $("#email").parent().addClass("has-error");
            $("#email").next().text("长度不能大于30");
            $("#email").next().show();
            flag = false;
        } else if (! szReg.test(email)) {
            $("#email").parent().addClass("has-error");
            $("#email").next().text("格式错误");
            $("#email").next().show();
            flag = false;
        }else {
            $('#email').parent().removeClass("has-error");
            $('#email').next().text("");
            $("#email").next().hide();
        }
    	
    }
    
    function checkPhone() {
    	var phone = $.trim($("#phone").val());
        var szReg= /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/; 
        if (phone == "") {
            $('#phone').parent().addClass("has-error");
            $('#phone').next().text("请输入手机号码");
            $("#phone").next().show();
            flag = false;
        } else if (phone.length > 11) {
            $("#phone").parent().addClass("has-error");
            $("#phone").next().text("长度不能大于11");
            $("#phone").next().show();
            flag = false;
        } else if (! szReg.test(phone)) {
            $("#phone").parent().addClass("has-error");
            $("#phone").next().text("格式错误");
            $("#phone").next().show();
            flag = false;
        }else {
            $('#phone').parent().removeClass("has-error");
            $('#phone').next().text("");
            $("#phone").next().hide();
        }
    }
    
    function checkPassword() {
    	var password = $.trim($("#password").val());
        var szReg= /^[a-zA-Z]\w{5,19}$/; 
        if (password == "") {
            $('#password').parent().addClass("has-error");
            $('#password').next().text("请输入密码");
            $("#password").next().show();
            flag = false;
        } else if (password.length > 20) {
            $("#password").parent().addClass("has-error");
            $("#password").next().text("长度不能大于20");
            $("#password").next().show();
            flag = false;
        } else if (! szReg.test(password)) {
            $("#password").parent().addClass("has-error");
            $("#password").next().text("格式错误");
            $("#password").next().show();
            flag = false;
        }else {
            $('#password').parent().removeClass("has-error");
            $('#password').next().text("");
            $("#password").next().hide();
        }
    }
    
    function checkPassword2() {
    	var password = $.trim($("#password").val());
    	var password2 = $.trim($("#password2").val());
        if (password2 == "") {
            $('#password2').parent().addClass("has-error");
            $('#password2').next().text("请输入确定密码");
            $("#password2").next().show();
            flag = false;
        } else if (password2.length > 20) {
            $("#password2").parent().addClass("has-error");
            $("#password2").next().text("长度不能大于20");
            $("#password2").next().show();
            flag = false;
        } else if (password2 != password) {
            $("#password2").parent().addClass("has-error");
            $("#password2").next().text("两次结果不一致");
            $("#password2").next().show();
            flag = false;
        }else {
            $("#password2").parent().removeClass("has-error");
            $("#password2").next().text("");
            $("#password2").next().hide();
        }
    }
    
    function validUpdate() {
    	   var flag = true;
    	    
    	    var email = $.trim($("#email").val());
    	    var szReg=/^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
    	    if (email == "") {
    	        $('#email').parent().addClass("has-error");
    	        $('#email').next().text("请输入邮箱");
    	        $("#email").next().show();
    	        flag = false;
    	    } else if (email.length > 30) {
    	        $("#email").parent().addClass("has-error");
    	        $("#email").next().text("长度不能大于30");
    	        $("#email").next().show();
    	        flag = false;
    	    } else if (! szReg.test(email)) {
    	        $("#email").parent().addClass("has-error");
    	        $("#email").next().text("格式错误");
    	        $("#email").next().show();
    	        flag = false;
    	    }else {
    	        $('#email').parent().removeClass("has-error");
    	        $('#email').next().text("");
    	        $("#email").next().hide();
    	    }
    	    
    	    var phone = $.trim($("#phone").val());
    	    var szReg= /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/; 
    	    if (phone == "") {
    	        $('#phone').parent().addClass("has-error");
    	        $('#phone').next().text("请输入手机号码");
    	        $("#phone").next().show();
    	        flag = false;
    	    } else if (phone.length > 11) {
    	        $("#phone").parent().addClass("has-error");
    	        $("#phone").next().text("长度不能大于11");
    	        $("#phone").next().show();
    	        flag = false;
    	    } else if (! szReg.test(phone)) {
    	        $("#phone").parent().addClass("has-error");
    	        $("#phone").next().text("格式错误");
    	        $("#phone").next().show();
    	        flag = false;
    	    }else {
    	        $('#phone').parent().removeClass("has-error");
    	        $('#phone').next().text("");
    	        $("#phone").next().hide();
    	    }
    	    
    	    var password = $.trim($("#password").val());
    	    var szReg= /^[a-zA-Z]\w{5,19}$/; 
    	    if (password == "") {
    	        $('#password').parent().addClass("has-error");
    	        $('#password').next().text("请输入密码");
    	        $("#password").next().show();
    	        flag = false;
    	    } else if (password.length > 20) {
    	        $("#password").parent().addClass("has-error");
    	        $("#password").next().text("长度不能大于20");
    	        $("#password").next().show();
    	        flag = false;
    	    } else if (! szReg.test(password)) {
    	        $("#password").parent().addClass("has-error");
    	        $("#password").next().text("格式错误");
    	        $("#password").next().show();
    	        flag = false;
    	    }else {
    	        $('#password').parent().removeClass("has-error");
    	        $('#password').next().text("");
    	        $("#password").next().hide();
    	    }
    	    
    	    var password = $.trim($("#passwordy").val());
        	var pwd = $.trim($("#pwd").val());
        	alert(password + "\n" + pwd);
            if (password == "") {
                $('#passwordy').parent().addClass("has-error");
                $('#passwordy').next().text("请输入原密码");
                $("#passwordy").next().show();
                flag = false;
            } else if (password.length > 20) {
                $("#passwordy").parent().addClass("has-error");
                $("#passwordy").next().text("长度不能大于20");
                $("#passwordy").next().show();
                flag = false;
            } else if (password != pwd) {
                $("#passwordy").parent().addClass("has-error");
                $("#passwordy").next().text("密码错误");
                $("#passwordy").next().show();
                flag = false;
            }else {
                $("#passwordy").parent().removeClass("has-error");
                $("#passwordy").next().text("");
                $("#passwordy").next().hide();
            }
    	    return flag;
    }
    
    $(function () {
        $('#submit').click(function () {
            if (!validUpdate()) {
                return;
            }
            $("form").submit();
        });

        var alert = $('.alert');
        var formWidth = $('.bootstrap-admin-login-form').innerWidth();
        var alertPadding = parseInt($('.alert').css('padding'));
        if (isNaN(alertPadding)) {
            alertPadding = parseInt($(alert).css('padding-left'));
        }
        $('.alert').width(formWidth - 2 * alertPadding);
    });