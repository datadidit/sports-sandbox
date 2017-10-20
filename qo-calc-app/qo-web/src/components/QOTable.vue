<template>
  <v-card>
    <v-card-title>
      Salaries
      <v-spacer></v-spacer>
      <v-text-field
        append-icon="search"
        label="Search"
        single-line
        hide-details
        v-model="search"
      ></v-text-field>
    </v-card-title>
    <v-data-table
        v-bind:headers="headers"
        v-bind:items="salaries"
        v-bind:search="search"
      >
      <template slot="items" scope="props">
        <td>
        {{props.item.name}}
        </td>
        <td class="text-xs-right">{{ props.item.salary }}</td>
      </template>
      <template slot="pageText" scope="{ pageStart, pageStop }">
        From {{ pageStart }} to {{ pageStop }}
      </template>
    </v-data-table>
  </v-card>
</template>

<script>
export default{
	name: 'qotable',
	props: ['salaries'],
	data(){
		return {
        	max25chars: (v) => v.length <= 25 || 'Input too long!',
        	tmp: '',
        	search: '',
        	pagination: {},			
			headers: [
				{
					text: 'Player Name',
					align: 'left',
					sortable: true,
					value: 'name'
				},
				{
					text: 'Salary',
					align: 'left',
					sortable: true,
					value: 'longSalary'
				}
			],
			/*players: [
				{
					name: 'Bryce Harper',
					salary: '$2,500,000',
					longSalary: 2500000
				},
				{
					name: 'Max Scherzer',
					salary: '$5,000,000',
					longSalary: 5000000
				}
			]*/
		}
	}	
}
</script>
