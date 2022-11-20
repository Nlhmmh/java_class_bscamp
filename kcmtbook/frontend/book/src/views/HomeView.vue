<template>
  <div>
     <h1>Book Management System</h1>
     <!--main-->
     <v-data-table 
     :headers="headers"
     :items="book"
     :items-per-page="5"
     class="elevation-5"></v-data-table>
  </div>
</template>

<script>
export default {
  name: 'home',
 
  components:{ 
     
  },

  data(){
    return{
      tableHeaders:[
        {
          text:'ID',
          value:'id',
          sortable:true,
         
        },
        {
          text:'Home',
          value:'name',
          sortable:true,
         
        },
        {
          text:'Author',
          value:'author',
          sortable:true,
         
        },
        {
          text:'Price',
          value:'price',
          sortable:true,
         
        },
        {
          text:'Type',
          value:'type',
          sortable:true,
         
        },
        {
          text:'Published Date',
          value:'publishedDate',
          sortable:true,
         
        },{
          text:'Created At',
          value:'createdAt',
          sortable:true,
         
        },
        {
          text:'Updated At',
          value:'updatedAt',
          sortable:true,
         
        },
        {
          text:'Calories',value:'Calories'
        },
        {
          text:'Fat(g)',value:'fat'
        },
        {
          text:'Carbs(g)',value:'carbs'
        },
        {
          text:'Protein(g)',value:'protein'
        },
        {
          text:'Iron(g)',value:'iron'
        }
      ],BookList:[]
        
      }
    },
    methods:{

}
}
</script>
