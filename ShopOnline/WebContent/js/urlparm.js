/**
 * 
 */

	function geturlvalue(name,url){
			var value="";

			var position=url.indexOf("?");
			var parameterStr=url.substr(position+1);//Get the string after ?
			var arr=parameterStr.split("&");
			for(i=0;i<arr.length;i++){
			var parameter=arr[i].split("=");
			if(parameter[0]==name){
			value=parameter[1];
			}
		}
		return value;
	}