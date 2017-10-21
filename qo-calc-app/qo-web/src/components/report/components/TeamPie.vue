<script>
	import { Pie, mixins } from 'vue-chartjs'
	const { reactiveProp } = mixins

	export default {
		name: 'teampie',
		extends: Pie,
	  	mixins: [reactiveProp],
		props: ['payroll', 'offers', 'options'],
		data(){
			return {
				options: { response: true, maintainAspectRatio: false}
			}
		},
  		mounted () {
  			console.log("Mounted")
   	 		// this.chartData is created in the mixin.
    		// If you want to pass options please create a local options object
    		this.renderChart(this.chartData, this.options)
  		}
    }
</script>