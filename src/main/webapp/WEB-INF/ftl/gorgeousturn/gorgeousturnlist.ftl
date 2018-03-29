<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8" />
		<title>用户列表 —个人中心</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<link   rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
		<link   rel="shortcut icon" href="${basePath}/favicon.ico" />
		<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>
		<link href="${basePath}/js/common/bootstrap/3.3.5/css/style.css" rel="stylesheet"/>
		<script  src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
		<script  src="${basePath}/js/common/layer/layer.js"></script>
		<script  src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script  src="${basePath}/js/common/jquery/Ecalendar.jquery.min.js"></script>
		<script  src="${basePath}/js/shiro.demo.js"></script>
		<script >
			<@shiro.hasPermission name="/gorgeousturn/addmeeting.shtml">
			<#--添加角色-->
			function addmeeting(){
				var meetingtitle = $('#meetingtitle').val(),
					meetingtime = $('#ECalendar_date').val();
				    meetingremark = $('#meetingremark').val();
				if($.trim(meetingtitle) == ''){
					return layer.msg('会议名称不能为空。',so.default),!1;
				}
				if($.trim(meetingtime) == ''){
					return layer.msg('会议时间不能为空。',so.default),!1;
				}
				<#--loding-->
				var load = layer.load();
				$.post('${basePath}/gorgeousturn/addmeeting.shtml',{meetingtitle:meetingtitle,meetingtime:meetingtime,meetingremark:meetingremark},function(result){
					layer.close(load);
					if(result && result.status != 200){
						return layer.msg(result.message,so.default),!1;
					}
					layer.msg('添加成功。');
					setTimeout(function(){
						$('#formId').submit();
					},1000);
				},'json');
			}
			</@shiro.hasPermission>
      $(function(){
		  $("#ECalendar_date").ECalendar({
			 type:"time",   //模式，time: 带时间选择; date: 不带时间选择;
			 stamp : false,   //是否转成时间戳，默认true;
			 offset:[0,2],   //弹框手动偏移量;
			 format:" yyyy-mm-dd hh:ii",   //时间格式 默认 yyyy-mm-dd hh:ii;
			 skin:3,   //皮肤颜色，默认随机，可选值：0-8,或者直接标注颜色值;
			 step:10,   //选择时间分钟的精确度;
			 callback:function(v,e){} //回调函数
		 });
    	})

		</script>
	</head>
	<body data-target="#one" data-spy="scroll">
		
		<@_top.top 4/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				 <#--  <@_left.member 3/>   -->
				<div class="col-md-10">
					<h2>会议列表</h2>
					<hr>
					<form method="post" action="" id="formId" class="form-inline">
						<div clss="well">
					      <div class="form-group">
					        <input type="text" class="form-control" style="width: 300px;" value="${findContent?default('')}" 
					        			name="findContent" id="findContent" placeholder="输入会议名称 /备注">
					      </div>
					     <span class=""> <#--pull-right -->
				         	<button type="submit" class="btn btn-primary">查询</button>
				         	<@shiro.hasPermission name="/gorgeousturn/addmeeting.shtml">
				         		<a class="btn btn-success" onclick="$('#addmeeting').modal();">增加会议</a>
				         	</@shiro.hasPermission>
				         </span>    
				        </div>
					<hr>
					<table class="table table-bordered">
						<tr>
							<th><input type="checkbox" id="checkAll"/></th>
							<th>ID</th>
							<th>会议名称</th>
							<th>会议时间</th>
							<th>备注</th>
							<th>操作</th>
						</tr>
						<#if page?exists && page.list?size gt 0 >
							<#list page.list as it>
								<tr>
									<td><input value="${it.id}" check='box' type="checkbox" /></td>
									<td>${it.id?default('未设置')}</td>
									<td>${it.meetingtitle?default('未设置')}</td>
									<td>${(it.meetingtime)?default('未设置')}</td>
									<td>${it.meetingremark?default('未设置')}</td>
									<td>
										<@shiro.hasPermission name="/gorgeousturn/forbidUserById.shtml">
										${(it.status==1)?string('<i class="glyphicon glyphicon-eye-close"></i>&nbsp;','<i class="glyphicon glyphicon-eye-open"></i>&nbsp;')}
										<a href="javascript:forbidUserById(${(it.status==1)?string(0,1)},${it.id})">
											${(it.status==1)?string('禁止登录','激活登录')}
										</a>
										</@shiro.hasPermission>
										<@shiro.hasPermission name="/gorgeousturn/deleteUserById.shtml">
										<a href="javascript:_delete([${it.id}]);">删除</a>
										</@shiro.hasPermission>
									</td>
								</tr>
							</#list>
						<#else>
							<tr>
								<td class="text-center danger" colspan="6">没有找到用户</td>
							</tr>
						</#if>
					</table>
					<#if page?exists>
						<div class="pagination pull-right">
							${page.pageHtml}
						</div>
					</#if>
					</form>
				</div>
			</div><#--/row-->
		</div>
		   <@shiro.hasPermission name="/gorgeousturn/addmeeting.shtml">
				<#--添加弹框-->
				<div class="modal fade" id="addmeeting" tabindex="-1" role="dialog" aria-labelledby="addroleLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="addroleLabel">添加会议</h4>
				      </div>
				      <div class="modal-body">
				        <form id="boxRoleForm">
				          <div class="form-group">
				            <label for="recipient-name" class="control-label">会议名称:</label>
				            <input type="text" class="form-control" name="meetingtitle" id="meetingtitle"  placeholder="请输入会议名称"/>
				          </div>
				          <div class="form-group">
				          <label for="recipient-name" class="control-label">会议时间:</label>
				          <div class="calendarWarp">
	                      <input type="text" name="meetingtime"  class='ECalendar' id="ECalendar_date" style="width: 300px;" value=""/>
                          <label for="recipient-name" class="control-label">*</label>
                           </div>
				          </div>
				          <div class="form-group">
				            <label for="recipient-name" class="control-label">会议描述:</label>
				            <textarea  class="form-control" name="meetingremark" id="meetingremark" ></textarea>
				          </div>
				        </form>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				        <button type="button" onclick="addmeeting();" class="btn btn-primary">Save</button>
				      </div>
				    </div>
				  </div>
				</div>
				<#--/添加弹框-->
			</@shiro.hasPermission>
	</body>
</html>