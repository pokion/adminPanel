function Search(){
	this.connect = async function(path){
		try{
			const search = await fetch(`http:localhost:8080/${path}`)
			return Promise.resolve(search.json())
		}catch (e){
			return Promise.reject(e)
		}
	}

	this.search = function(string, callback){
		this.connect('search/'+string)
		.then(products => {
			callback(products)
		}).catch( err => {
			console.log(err)
		})
	}
}