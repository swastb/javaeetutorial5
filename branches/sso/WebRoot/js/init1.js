///////////////////////////////////////////////////////////////// INIT ////////////////////////////////////////////////////////////

//  Init!

var OutlookBar={
"format":
   {"heightpanel":25, "imageheight":32, "arrowheight":17,"heightcell":76,"coloroutlook":"#FFFFFF","arrange_text":"bottom", "rollback":false, "img_arrows_up":"img/arup.gif","img_arrows_dn":"img/ardn.gif"},
"panels":
[
   {"text":"公共事务", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"一周安排","textCSS":"a1", "image":'imagine/dl-a1.gif',    "url":'weekplannew.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"会议管理","textCSS":"a2", "image":'imagine/dl-a2.gif',  "url":'#', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"车辆管理","textCSS":"a3","image":'imagine/dl-a5.gif',  "url":'#', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"节假日管理","textCSS":"a4","image":'imagine/dl-a7.gif', "url":'oaholidayaction.do?method=list', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"日程管理","textCSS":"a4","image":'imagine/dl-a7.gif', "url":'tbZwWeekSecheduleAction?method=list', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"签到查询","textCSS":"a5","image":'imagine/dl-a6a.gif',    "url":'#', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"}
      ]
   },
   {"text":"防汛应用", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"防汛值班","textCSS":"a1", "image":'imagine/dl-a8.gif',    "url":'#', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"水情报讯","textCSS":"a2", "image":'imagine/dl-a9.gif',  "url":'#', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"WebGIS应用系统","textCSS":"a3", "image":'imagine/dl-a10.gif',  "url":'#', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"手动预警设置","textCSS":"a1", "image":'imagine/dl-a11.gif', "url":'#', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"短信平台","textCSS":"a2", "image":'imagine/dl-a13.gif',    "url":'#', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"传真平台","textCSS":"a3", "image":'imagine/dl-a12.gif',    "url":'#', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"}
          
      ]
   },
   {"text":"公文档案", "panelCSS":"panel" , "textCSS":"textpanel",
       "items":
       [
          {"text":"大事记","textCSS":"a1", "image":'imagine/dl-a14.gif',    "url":'#', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"档案管理","textCSS":"a2", "image":'imagine/dl-a15.gif',  "url":'#', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"}
          
      ]
   },
  {"text":"系统管理", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"职务等级管理","textCSS":"a1", "image":'imagine/dl-a1.gif',    "url":'pstlvlaction.do?method=list', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"权限类型管理","textCSS":"a2", "image":'imagine/dl-a2.gif',  "url":'righttypeaction.do?method=list', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"用户级别管理","textCSS":"a3","image":'imagine/dl-a5.gif',  "url":'userlvlaction.do?method=list', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"权限级别管理","textCSS":"a4","image":'imagine/dl-a7.gif', "url":'authlvlaction.do?method=list', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"部门级别管理","textCSS":"a5","image":'imagine/dl-a6.gif',    "url":'deptlvlaction.do?method=list', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"应用系统管理","textCSS":"a1","image":'imagine/dl-a6.gif',    "url":'allappSys.do?method=list', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"功能资源管理","textCSS":"a2","image":'imagine/dl-a6.gif',    "url":'base/function/navigation.do', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"角色管理","textCSS":"a3","image":'imagine/dl-a6.gif',    "url":'roleaction.do?method=list', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"组织机构管理","textCSS":"a4","image":'imagine/dl-a6.gif',    "url":'orgmainaction.do', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"角色权限管理","textCSS":"a5","image":'imagine/dl-a6.gif',    "url":'base/roleAuth/navigation.do', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"角色用户管理","textCSS":"a1","image":'imagine/dl-a6.gif',    "url":'roleusermainaction.do', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"用户所属角色","textCSS":"a1","image":'imagine/dl-a6.gif',    "url":'roletreeaction.do?method=roleOfUserList', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"}
      ]
   }, 
   {"text":"个性化", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"个性化定制","textCSS":"a1", "image":'imagine/dl-a1.gif',    "url":'base/function/forwardFunction.do?method=resListByUser', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},       
          {"text":"节假日管理","textCSS":"a4","image":'imagine/dl-a7.gif', "url":'oaholidayaction.do?method=list', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"日程管理","textCSS":"a4","image":'imagine/dl-a7.gif', "url":'tbZwWeekSecheduleAction.do?method=list&action=alllist', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
           {"text":"会议管理","textCSS":"a5", "image":'imagine/dl-a2.gif',  "url":'meetingaction.do?method=list&action=thismonth', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},


          {"text":"会议室管理","textCSS":"a5", "image":'imagine/dl-a2.gif',  "url":'meetingroomaction.do?method=list', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          
          {"text":"个人通讯组管理","textCSS":"a5", "image":'imagine/dl-a2.gif',  "url":'individualcommaction.do?method=list&groupname=', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"个人通讯管理","textCSS":"a5", "image":'imagine/dl-a2.gif',  "url":'individualaction.do?method=list&pername=&perphone=', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          
          {"text":"公共通讯录","textCSS":"a4", "image":'imagine/dl-a2.gif',  "url":'commonalityaction.do?method=list&action=all', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"公共通讯组","textCSS":"a4", "image":'imagine/dl-a2.gif',  "url":'commonalityCommAction.do?method=list', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          {"text":"信息发布管理","textCSS":"a4", "image":'imagine/dl-a2.gif',  "url":'infopubclaaction.do?method=maininfo', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"},
          
          {"text":"wenbenbianji","textCSS":"a4", "image":'imagine/dl-a2.gif',  "url":'infopubContentaction.do?method=test', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over","target":"rightFrame"}
          
       ]
   }       
]
}
