<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/26
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>

<script>
    function createXmlHttpRequest(){
        try{
            return new XMLHttpRequest();
        }catch(e){
            try{
                return new  ActiveXObject("MSXML2.XMLHTTP")
            }catch(e){
                try{
                    return new ActiveXObject("Microsoft.XMLHTTP")
                }catch(e){
                    alert("你的浏览器太老了")
                }
            }
        }
    }

    window.onload = function () {
        alert("adsadadasd")
        var sub = document.getElementById("sub").onclick=function () {
            var username = document.getElementById("user").value;
            var password = document.getElementById("password").value;
            alter(username+"\t"+password)
            var xmlhttprequest = createXmlHttpRequest();
            xmlhttprequest.open("POST","/servlet",true)
            xmlhttprequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
            xmlhttprequest.send("user="+username+"&"+"password="+password)
        }
    }

</script>
