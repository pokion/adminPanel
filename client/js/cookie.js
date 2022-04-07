function Cookies(){

	this.addCookie = (name, value) => {

		let cookies = document.cookie;

		if (cookies.length == 0) {
			document.cookie = `${name}=${value}`;
		}else{
			let mapCookies = this.parseCookie(cookies);

			if(mapCookies.get(name) != undefined){
				mapCookies.set(name, mapCookies.get(name) + '|' + value);
			}else{
				mapCookies.set(name, value);
			}

			this.setCookie(mapCookies)
		}
	}

	this.parseCookie = (cookie) => {
		let cookiesArray = cookie.split('; ');
		let mapCookie = new Map();

		for(let cookie of cookiesArray){
			let cookieParse = cookie.split('=');
			mapCookie.set(cookieParse[0], cookieParse[1])
		}

		return mapCookie;
	}

	this.setCookie = (mapOfCookies) => {
		let cookieToSet = "";

		for (const key of mapOfCookies){

			cookieToSet += `${key[0]}=${key[1]}; `;
		}

		document.cookie = cookieToSet;
	}

	this.getCookie = (name) => {

		if(document.cookie){
			let mapOfCookies = this.parseCookie(document.cookie);
			return mapOfCookies.get(name);
		}else{
			return [];
		}
	
	}
}