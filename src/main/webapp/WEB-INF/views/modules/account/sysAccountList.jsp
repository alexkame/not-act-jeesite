<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>账户信息表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/account/sysAccount/">账户信息表列表</a></li>
		<shiro:hasPermission name="account:sysAccount:edit"><li><a href="${ctx}/account/sysAccount/form">账户信息表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysAccount" action="${ctx}/account/sysAccount/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				
				<th>姓名</th>
				<th>账户类型</th>
				<th>电话号</th>
				<th>手机号</th>
				<th>email</th>
				<th>头像</th>
				<th>qq</th>
				<th>微信昵称</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="account:sysAccount:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysAccount">
			<tr>
				<td><a href="${ctx}/account/sysAccount/form?id=${sysAccount.id}">
					${sysAccount.name}
				</a></td>
				
				<td>
					${sysAccount.userType}
				</td>
				<td>
					${sysAccount.phone}
				</td>
				<td>
					${sysAccount.mobile}
				</td>
				<td>
					${sysAccount.email}
				</td>
				<td>
					${sysAccount.photo}
				</td>
				<td>
					${sysAccount.qq}
				</td>
				
				<td>
				<a href="${ctx}/wechat/sysWechat/form?id=${sysAccount.wechat.id}">
					${sysAccount.wechat.nickname}
				</a>
				
					
				</td>
				<td>
					<fmt:formatDate value="${sysAccount.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${sysAccount.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sysAccount.remarks}
				</td>
				<shiro:hasPermission name="account:sysAccount:edit"><td>
    				<a href="${ctx}/account/sysAccount/form?id=${sysAccount.id}">修改</a>
					<a href="${ctx}/account/sysAccount/delete?id=${sysAccount.id}" onclick="return confirmx('确认要删除该账户信息表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>