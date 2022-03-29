function productTriger(){

	Array.from(document.querySelectorAll('.quickView')).forEach((el)=>{
		el.addEventListener('mouseenter', (event)=>{
			event.target.querySelector('.product--triger').classList.remove('invisibleOpacity')
		})
		el.addEventListener('mouseleave', (event)=>{
			event.target.querySelector('.product--triger').classList.add('invisibleOpacity')
		})
	})
}

productTriger()