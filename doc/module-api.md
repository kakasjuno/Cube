# 模块化REST API

##获取应用信息

##检查更新

*请求*

`/url`

    {
        identifier:"com.csair.istation",
        url: "http://localhost/applications/istation"
    	version:"1.1",
    	modules:[
    		{identifier:"com.csair.icabin.passenger", name:"Passenger", version:"1.1"},
    		{identifier:"com.csair.istation.help", name:"CheckIn", version:"1.2"}
    	],
    	extra-modules:[
    		{identifier:"com.csair.icabin.weather", name:"Weather", version:"1.1"}
    	]
    }


*响应*

    {
        identifier:"com.csair.istation",
    	download_url: "http://localhost/applications/istation.zip"
    	version:"1.2",
    	modules:[
    		{identifier:"com.csair.icabin.passenger", name:"Passenger", version:"1.1"},
    		{identifier:"com.csair.istation.help", name:"CheckIn", version:"1.3"}
    	],
    	extra-modules:[
    		{identifier:"com.csair.icabin.weather", name:"Weather", version:"1.2"}
    	]
    }