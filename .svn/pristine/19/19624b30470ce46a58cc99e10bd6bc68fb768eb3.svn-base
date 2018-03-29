<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8" />
		<title>当前在线Session — SSM + Shiro Demo</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<link   rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
		<link   rel="shortcut icon" href="${basePath}/favicon.ico" />
		<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>
		<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet"/>
		<script  src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
		<script  src="${basePath}/js/common/layer/layer.js"></script>
		<script  src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script  src="${basePath}/js/shiro.demo.js"></script>
		
	</head>
	<body data-target="#one" data-spy="scroll">
		
		<@_top.top 4/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<div class="col-md-10">
					<h2>华丽转身会议</h2>
					<hr>
					<form method="post" action="" id="formId" class="form-inline">
						<div clss="well">
				        </div>
					<hr>
					<table class="table table-bordered">
						<tr>
							<th>ID</th>
							<th>会议名称</th>
							<th>会议时间</th>
							<th>备注</th>
							<th>操作</th>
							
						</tr>
						<#if list?exists && list?size gt 0 >
							<#list list as it>
								<tr>
									<td>${it.id?default('未设置')}</td>
									<td>${it.meetingtitle?default('未设置')}</td>
									<td>${it.meetingtime?string('yyyy-MM-dd HH:mm')}</td>
									<td>${it.meetingremark?default('未设置')}</td>
									<td>
										
									</td>
								</tr>
							</#list>
						<#else>
							<tr>
								<td class="center-block" callspan="4">没有用户</td>
							</tr>
						</#if>
						
					</table>
				</div>
			</div><#--/row-->
		</div>
			
	</body>
</html>