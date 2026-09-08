//event 包含event对象
//xhr 包含XMLHttpRequest对象
//option 包含AJAX请求中使用的选项
$(document).ajaxSend(function (event, xhr, options) {
    var token = localStorage.getItem("userToken");
    if (token) {
        xhr.setRequestHeader("user_token", token);
    }
});

//用ajaxError 对失败进行统一的处理
$(document).ajaxError(function(event,xhr,option){
    if (xhr.status==401) {
        location.href = "blog_login.html";
    }
})
function getUserInfo(url) {
    $.ajax({
        type: "get",
        url: url,
        success: function (result) {
            if (result != null && result.code == "SUCCESS" && result.data != null) {
                var userInfo = result.data;
                $(".left .card h3").text(userInfo.userName);
                $(".left .card a").attr("href",userInfo.githubUrl);
            }
        }
    })
 }

 function logout(){
    localStorage.removeItem("userToken");
    localStorage.removeItem("loginUserId");
    location.href = "blog_login.html";
 }