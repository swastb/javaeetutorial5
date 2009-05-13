var OUTLOOKBAR_DEFINITION = {
	format:{
		target:'rightFrame',
		blankImage:'images1/b.gif',
		rollback:true,
		animationSteps:3,
		animationDelay:20,
		templates:{
			panel:{
				common:'<table width="100%" height="37" border="0" cellspacing="0" cellpadding="0" background="images1/panel_middle_{state}.gif"><tr><td><img src="images1/panel_left_{state}.gif" width="10" height="37" /></td><td align="center"><div style="font: bold 11pt trebuchet ms, arial;">{text}</div></td><td align="right"><img src="images1/panel_right_{state}.gif" width="10" height="37" /></td></tr></table>',
				normal:{state:'n'}
			},
			item:{
				common:'<table border="0" width="100%"><tr><td><table width="100%" bgcolor="{borderColor}" border="0" cellspacing="1" cellpadding="0"><tr><td><table width="100%" border="0" bgcolor="{backgroundColor}" cellspacing="0" cellpadding="5"><tr align="center"><td><img src="images1/icon_{icon}_{state}.gif" width="48" height="48" /></td></tr><tr align="center"><td><span style="font: 9pt verdana;">{text}</span></td></tr></table></td></tr></table></td></tr></table>',
				normal:{borderColor:'#D0D0D0', backgroundColor:'#D0D0D0', state:'n'}
			},
			upArrow:{
				common:'<img src="images1/btn_up_{state}.gif" width="24" height="24" />',
				normal:{state:'n'}
			},
			downArrow:{
				common:'<img src="images1/btn_down_{state}.gif" width="24" height="24" />',
				normal:{state:'n'}
			}
		}
	},
	panels:[
		{text:"公共事务", url:'',
			items:[
				{text:"一周安排", icon:'01', url:'weekplannew.htm'},
				{text:"会议管理", icon:'02', url:''},
				{text:"车辆管理", icon:'03', url:''},
				{text:"节假日管理", icon:'04', url:'oaholidayaction.do?method=list'},
				{text:"日程管理", icon:'05', url:'tbZwWeekSecheduleAction.do?method=list&action=alllist'},
				{text:"签到查询", icon:'06', url:''}
			]
		},	
		{text:"防汛应用", url:'',
			items:[
				{text:"防汛值班", icon:'01', url:''},
				{text:"水情报讯", icon:'02', url:''},
				{text:"WebGIS应用系统", icon:'03', url:''},
				{text:"手动预警设置", icon:'04', url:''},
				{text:"短信平台", icon:'05', url:''},
				{text:"传真平台", icon:'06', url:''}
			]
		},
		{text:"系统管理", url:'',
			items:[
				{text:"职务等级管理", icon:'01', url:'pstlvlaction.do?method=list'},
				{text:"权限类型管理", icon:'02', url:'righttypeaction.do?method=list'},
				{text:"用户级别管理", icon:'02', url:'userlvlaction.do?method=list'},
				{text:"权限级别管理", icon:'02', url:'authlvlaction.do?method=list'},
				{text:"部门级别管理", icon:'02', url:'deptlvlaction.do?method=list'},
				{text:"应用系统管理", icon:'02', url:'allappSys.do?method=list'},
				{text:"功能资源管理", icon:'02', url:'base/function/navigation.do'},
				{text:"角色管理", icon:'02', url:'roleaction.do?method=list'},
				{text:"组织机构管理", icon:'02', url:'orgmainaction.do'},
				{text:"角色权限管理", icon:'02', url:'base/roleAuth/navigation.do'},
				{text:"角色用户管理", icon:'02', url:'roleusermainaction.do'},
				{text:"用户所属角色", icon:'02', url:'roletreeaction.do?method=roleOfUserList'}
			]
		},
		{text:"个性化", url:'',
			items:[
				{text:"信息发布管理", icon:'01', url:'infopubclaaction.do?method=maininfo'},
				{text:"个性化定制", icon:'01', url:'base/function/forwardFunction.do?method=resListByUser'},
				{text:"节假日管理", icon:'02', url:'oaholidayaction.do?method=list'},
				{text:"日程管理", icon:'02', url:'tbZwWeekSecheduleAction.do?method=list&action=alllist'},
				{text:"会议管理", icon:'02', url:'meetingaction.do?method=list&action=thismonth'},
				{text:"会议室管理", icon:'02', url:'meetingroomaction.do?method=list'},
				{text:"个人通讯组管理", icon:'02', url:'individualcommaction.do?method=list&groupname='},
				{text:"个人通讯管理", icon:'02', url:'individualaction.do?method=list&pername=&perphone='},
				{text:"公共通讯录", icon:'02', url:'commonalityaction.do?method=list&action=all'},
				{text:"公共通讯组", icon:'02', url:'commonalityCommAction.do?method=list'}
			]
		}								
		
	]
};
