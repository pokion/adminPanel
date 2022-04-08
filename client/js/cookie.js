function Cookies(){

	this.addCookie = (name, value) => {
		document.cookie = `${name}=${value}`
	}

	this.parseCookie = (cookie) => {
		let cookiesArray = cookie.split('; ');
		let mapCookie = new Map();
		for(let cookie of cookiesArray){
			if (cookie != ""){
				let cookieParse = cookie.split('=');
				mapCookie.set(cookieParse[0], cookieParse[1])
			}
		}

		return mapCookie;
	}

	this.deleteCookie = (name) => {
		document.cookie = name+"=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
	}

	this.getCookie = (name) => {

		if(document.cookie){
			let mapOfCookies = this.parseCookie(document.cookie);
			return mapOfCookies.get(name);
		}else{
			return '';
		}
	}

	this.addToCookie = (name, val, delimeter) => {
		let cookie = this.getCookie(name);
		if(cookie){
			document.cookie = `${name}=${val+delimeter+cookie}`
		}else{
			document.cookie = `${name}=${val}`
		}
		
	}
}