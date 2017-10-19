<template>
<div>
	<qostats :mean="mean"></qostats>
	<qotable :salaries="salaries"></qotable>
</div>
</template>

<script>
import QOTable from './QOTable.vue'
import QOStats from './QOStats.vue'

export default {
	name: 'qoreport',
	components: {
		'qotable' : QOTable,
		'qostats' : QOStats
	},
	computed: {
		salaries(){
			return this.$store.getters.salaries
		},
		mean(){
			return this.$store.getters.mean
		}
	},
	mounted(){
		this.$store.dispatch('calculateQOReport', 125)
	}
}
</script>