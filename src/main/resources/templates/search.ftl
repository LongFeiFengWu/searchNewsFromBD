<html> 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body> 
  <h3>当前搜索关键字的关键字如下： (如需修改请直接修改D:\\search.txt，关键词以英文逗号分隔)</h3>

 <div style="color:red; font-size:20px;">
  	<#list keys as node>
	 ${node}
	</#list>
 </div>
 
 <h3>搜索完成，花费时间： ${excTime} 秒</h3>
 <div>
  	<#list keys as node>
 <div>
  	<h4>${node} :</h4> 
      <#assign item = newsInfosMap[node]> 
        <#list item as c>
        <#if c??>
        <p style="font-size:14px;">${c.title}  &nbsp&nbsp  ${c.authInfo} &nbsp&nbsp   <a href=${c.link} target="_blank" >${c.link}</a> </p> 
        </#if>   
        </#list>
   </div>
	 </#list>
 </div>

</body> 

</html>