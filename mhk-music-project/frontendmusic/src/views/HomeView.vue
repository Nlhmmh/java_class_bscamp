<template>
  <div class="ma-5">
    <v-row class="ma-0">
      <h1 class="mb-3">Music Management System</h1>
      <v-spacer></v-spacer>
      <v-btn color="blue" dark @click="onClickCreateBtn()">Create</v-btn>
    </v-row>

    <v-data-table
    class="elevation-4"
    :headers="tableHeaders"
    :items="musicList"
    :items-per-page="5">
      <template v-slot:item.actions="{item}">
        <v-btn class="mr-3" color="blue"
        fab x-small dark @click="onClickEditBtn(item)">
        <v-icon>mdi-pencil</v-icon>

        </v-btn>

        <v-btn class="mr-3" color="red"
        fab x-small dark @click="onClickDeleteBtn(item)" >
        <v-icon>mdi-delete</v-icon>

        </v-btn>
      </template>

    </v-data-table>

    <v-dialog v-model="createDialog" width="500">
    <v-card>
      <v-card-text>
        <v-form ref="createMusicForm" v-model="createMusicForm">
          <h3 class="pt-10">Add New Music</h3>
        <v-text-field
        v-model="name" label="Name" placeholder="Enter song name"
        :rules="[(v)=> !!v || 'Required']"
        required
        ></v-text-field>
      
        <v-text-field
        v-model="singer" label="Singer" placeholder="Enter singer name"
        :rules="[(v)=> !!v || 'Required']"
        required
        ></v-text-field>

        <v-select v-model="type" :items="['pop','rock','classic']" label="Type"
        :rules="[(v)=> !!v || 'Required']"
        required
        >
        
        </v-select>

        <v-btn class="mt-5" width="100" color="success" @click="createMusic()">Create</v-btn>

      </v-form>
      </v-card-text>
    </v-card>
    </v-dialog>

    <v-dialog v-model="editDialog" width="500">
    <v-card>
      <v-card-text>
        <v-form ref="editMusicForm" v-model="editMusicForm">
          <h3 class="pt-10">Edit Music</h3>
        <v-text-field
        v-model="name" label="Name" placeholder="Enter song name"
        :rules="[(v)=> !!v || 'Required']"
        required
        ></v-text-field>
      
        <v-text-field
        v-model="singer" label="Singer" placeholder="Enter singer name"
        :rules="[(v)=> !!v || 'Required']"
        required
        ></v-text-field>

        <v-select v-model="type" :items="['pop','rock','classic']" label="Type"
        :rules="[(v)=> !!v || 'Required']"
        required
        >
        
        </v-select>

        <v-btn class="mt-5" width="100" color="success" @click="editMusic()">Edit</v-btn>

      </v-form>
      </v-card-text>
    </v-card>
    </v-dialog>


    <v-dialog v-model="deleteDialog" width="500">
    <v-card>
      <v-card-title>Delete Music</v-card-title>
      <v-card-text> Are you sure to delete this music?
       
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="error" dark @click="deleteMusic()">Delete</v-btn>
        <v-btn color="blue" dark @click="deleteDialog=false">Cancel</v-btn>
      </v-card-actions>
    </v-card>
    </v-dialog>

   
  </div>
</template>

<script>
  import api from "../util/api.js";
  export default {
    data(){
      return {
        tableHeaders:[
          {
            text:"ID",
            value:"id",
            sortable:true,
          },
          {
            text:"Name",
            value:"name",
            sortable:true,
          },
          {
            text:"Singer",
            value:"singer",
            sortable:true,
          },
          {
            text:"Type",
            value:"type",
          },
          {
            text:"Created At",
            value:"createdAt",
          },
          {
            text:"Updated At",
            value:"updatedAt",
          },
          {
            text:"Actions",
            value:"actions",
          },
        ],
        musicList:[],

        deleteDialog:false,
        toDeleteMusic:{},

        createDialog:false,
        createMusicForm:false,

        name:"",
        singer:"",
        type:"pop",

        editDialog:false,
        editMusicForm:false,
        toEditId:0
      }
    },
   async created(){
      await this.fetchMusicList();
    },

    methods:{
      async fetchMusicList(){
        const resp=await api.get("/api/music");
        if(resp && resp.status==200){
          const data=await resp.json();
          if(data){
            this.musicList=data;
          }
        }
      },

     

      onClickCreateBtn(){
        this.createDialog=true;
      },

      async createMusic(){
        if(this.$refs.createMusicForm.validate()){
          const resp=await api.post("/api/music",{
            name:this.name,
            singer:this.singer,
            type:this.type,
            publishedDate:"2022-10-01"
          });
          if(resp && resp.status==200){
            await this.fetchMusicList();
            this.name="";
            this.singer="";
            this.type="pop";
            this.createDialog=false;
          }
        }
      },

      onClickEditBtn(item){
        this.toEditId=item.id;
        this.name=item.name;
        this.singer=item.singer;
        this.type=item.type;
        this.editDialog=true;
      },

      async editMusic(){
        if(this.$refs.editMusicForm.validate()){
          const resp=await api.put("/api/music",{
            id:this.toEditId,
            name:this.name,
            singer:this.singer,
            type:this.type,
            publishedDate:"2022-12-10",
          });
          if(resp && resp.status==200){
            await this.fetchMusicList();
            this.toEditId=0;
            this.name="";
            this.singer="";
            this.type="pop";
            this.editDialog=false;
          }
        }
      },

      onClickDeleteBtn(item){
        this.deleteDialog=true;
        this.toDeleteMusic=item;
      },

     
      async deleteMusic(){
        const resp=await api.del("/api/music",{
          id:this.toDeleteMusic.id,
        });
        if(resp && resp.status==200){
          await this.fetchMusicList();
          this.deleteDialog=false;
        }
      }
    }
  }
</script>
