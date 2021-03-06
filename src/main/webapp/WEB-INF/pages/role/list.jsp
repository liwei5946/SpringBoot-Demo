<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>角色列表</title>
</head>
<body>
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="ace-icon fa fa-home home-icon"></i> <a href="${ctx }">首页</a></li>
		</ul>

		<div class="nav-search" id="nav-search">
			<form class="form-search">
				<span class="input-icon"> <input type="text" placeholder="Search ..." class="nav-search-input"
					id="nav-search-input" autocomplete="off" /> <i class="ace-icon fa fa-search nav-search-icon"></i>
				</span>
			</form>
		</div>
	</div>

	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<h3 class="header smaller lighter blue">角色列表</h3>
				<div class="clearfix">
					<div class="pull-left tableTools-container">
						<a class="btn btn-primary" href="${ctx }/role/create">新建角色</a>
					</div>
				</div>

				<div>
					<table id="dynamic-table" class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>编号</th>
								<th>名称</th>
								<th>操作</th>
							</tr>
						</thead>

						<tbody>
							<c:if test="${roles == null}">
								<td colspan="5">没有数据</td>
							</c:if>
							<c:forEach var="role" items="${roles }">
								<tr>
									<td>${role.id}</td>
									<td>${role.name}</td>
									<td>
										<div class="hidden-sm hidden-xs action-buttons">
											<a class="green" href="${ctx }/role/edit?id=${role.id}"> <i class="ace-icon fa fa-pencil bigger-130"></i></a>
											<a class="red" href="${ctx }/role/delete?id=${role.id}"> <i class="ace-icon fa fa-trash-o bigger-130"></i></a>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- /.page-content -->
</body>
</html>