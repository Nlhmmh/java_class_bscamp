<template>
  <div>
    <v-container>

      <!-- Title & Create Btn -->
      <v-row class="ma-0">
        <h1 class="mb-3">Book Management System</h1>
        <v-spacer></v-spacer>
        
          <v-btn icon @click="onClickCreateBtn()">
            <v-icon size="30">mdi-plus-box</v-icon>
          </v-btn>
        
      </v-row>
      
      <!-- book table -->
      <v-data-table
        :headers="tableHeaders"
        :items="bookLists"
        :items-per-page="5"
        class="elevation-4"
      >
        <template v-slot:item.actions="{ item }">
          <!-- Edit book -->
          <v-btn class="mr-3" color="primary" fab x-small dark @click="onClickEditBtn(item)">
            <v-icon>mdi-pencil</v-icon>
          </v-btn>

          <!-- Delete book -->
          <v-btn color="red" fab x-small dark @click="onClickDeleteBtn(item)">
            <v-icon>mdi-delete</v-icon>
          </v-btn>
          

        </template>
      </v-data-table>

          <!-- Create dialog -->
          <v-dialog v-model="createDialog" width="500">
            <v-card>
              <v-card-title>Create Book</v-card-title>
              <v-card-text>
                <v-form ref="createBookForm" v-model="createBookForm">
                  <!-- Name Text Field-->
                  <v-text-field 
                  v-model="name" 
                  label="Name" 
                  placeholder="Enter Book's name"
                  :rules="[(v) => !!v || 'Required']" required>
                  </v-text-field>

                  <!-- Author Text Field-->
                  <v-text-field 
                  v-model="author" 
                  label="Author" 
                  placeholder="Enter Author's name"
                  :rules="[(v) => !!v || 'Required']" required>
                  </v-text-field>

                  <!-- Price Text Field-->
                  <v-text-field 
                    v-model="price" 
                    label="Price" 
                    placeholder="Enter Book's price"
                    type="number"
                    :rules="[(v) => !!v || 'Required']"
                    required>
                  </v-text-field>

                  <!-- Type Text Field-->
                  <v-select 
                  v-model="type" 
                  label="Choose Book's Type"
                  :items="['romance', 'adventure', 'comedy']"
                  required>
                  </v-select>

                  <v-btn class="mt-5 width-100" color="success" @click="createBook()">Create</v-btn>
                </v-form>
                
                </v-card-text>
            </v-card>
          </v-dialog>


          <!-- Edit dialog -->
          <v-dialog v-model="editDialog" width="500">
            <v-card>
              <v-card-title>Edit Book</v-card-title>
              <v-card-text>
                <v-form ref="editBookForm" v-model="editBookForm">
                  <!-- Name Text Field-->
                  <v-text-field 
                  v-model="name" 
                  label="Name" 
                  placeholder="Enter Book's name"
                  :rules="[(v) => !!v || 'Required']" required>
                  </v-text-field>

                  <!-- Author Text Field-->
                  <v-text-field 
                  v-model="author" 
                  label="Author" 
                  placeholder="Enter Author's name"
                  :rules="[(v) => !!v || 'Required']" required>
                  </v-text-field>

                  <!-- Price Text Field-->
                  <v-text-field 
                    v-model="price" 
                    label="Price" 
                    placeholder="Enter Book's price"
                    type="number"
                    :rules="[(v) => !!v || 'Required']"
                    required>
                  </v-text-field>

                  <!-- Type Text Field-->
                  <v-select 
                  v-model="type" 
                  label="Choose Book's Type"
                  :items="['romance', 'adventure', 'comedy']"
                  required>
                  </v-select>

                  <v-btn class="mt-5 width-100" color="success" @click="editBook()">Edit</v-btn>
                </v-form>
                
                </v-card-text>
            </v-card>
          </v-dialog>


          <!-- Delete dialog -->
          <v-dialog v-model="deleteDialog" width="500">
            <v-card>
              <v-card-title>Delete Book</v-card-title>
              <v-card-text>
                You are going to delete this book<br><br>
                <v-row>
                  <v-col cols="4">ID: </v-col>
                  <v-col cols="8">{{ toDeleteBook.id }}</v-col>
                  <v-col cols="4">Name: </v-col>
                  <v-col cols="8">{{ toDeleteBook.name }}</v-col>
                </v-row>
                </v-card-text>
              <v-card-actions>
              <v-spacer></v-spacer>
                <v-btn @click="deleteDialog=false">Cancel</v-btn>
                <v-btn color="red" dark @click="deleteBook(toDeleteBook.id)">Delete</v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>

    </v-container>
  </div>
</template>

<script>

  import api from "@/utils/api.js";
  

  export default {
    name: 'Home',

    components: {},

    data(){
      return{
        tableHeaders:[
          {
            text: 'ID',
            value: 'id',
            sortable: true,
          },
          {
            text: 'Name',
            value: 'name',
            sortable: true,
          },
          {
            text: 'Author',
            value: 'author',
            sortable: true,
          },
          {
            text: 'Price',
            value: 'price',
            sortable: true,
          },
          {
            text: 'Type',
            value: 'type',
          },
          {
            text: 'Published Date',
            value: 'publishedDate',
          },
          {
            text: 'Created At',
            value: 'createdAt',
          },
          {
            text: 'Updated At',
            value: 'updatedAt',
          },
          {
            text: 'Actions',
            value: 'actions',
            sortable: false,
          },
        ],
        bookLists:[],

        deleteDialog: false,
        toDeleteBook: false,

        createDialog: false,
        createBookForm: false,
        name: "",
        author: "",
        price: 0,
        type: "romance",

        editDialog: false,
        editBookForm: false,
        toEditID: 0,
      };
    },


//Run once when screen is loaded
    async created(){
      await this.fetchBookList();
    },

    methods: {
      async fetchBookList(){
        const resp = await api.get("/api/book");
            // console.log(resp.status);
      // if(resp != undefined && resp != null){}
            if(resp && resp.status === 200){
              const data =await resp.json();
              //  console.log(data);
              if(data){
                this.bookLists = data;
              }
            }
      },

      onClickCreateBtn(){
        this.createDialog = true;
      },

      async createBook(){
        if(this.$refs.createBookForm.validate()){
          const resp = await api.post("/api/book",{
            name: this.name,
            author: this.author,
            price: this.price,
            type: this.type,
            publishedDate: "2020-10-01",
          })
          if(resp && resp.status === 200){
            await this.fetchBookList();
            this.createDialog = false;

            this.name = "";
            this.author = "";
            this.price = 0;
            this.type = "romance";

          }
        }else{
                console.log("Creation fail");
        }
      },
      
      onClickEditBtn(item){
        this.toEditID = item.id;
        this.name = item.name;
        this.author = item.author;
        this.price = item.price;
        this.type = item.type;
        this.editDialog = true;
      },

      async editBook(){
        if(this.$refs.editBookForm.validate()){
          const resp = await api.put("/api/book",{
            id: this.toEditID,
            name: this.name,
            author: this.author,
            price: this.price,
            type: this.type,
            publishedDate: "2020-10-01",
          })
          if(resp && resp.status === 200){
            await this.fetchBookList();
            this.editDialog = false;

            // this.name = "";
            // this.author = "";
            // this.price = 0;
            // this.type = "romance";

          }
        }else{
          console.log("Edit fail");
        }
      },

      
      onClickDeleteBtn(item){
        this.toDeleteBook = item;
        this.deleteDialog = true;
      },
      async deleteBook(toDeleteID){
        const resp = await api.del("/api/book",{
          id: toDeleteID,
        })
        if(resp && resp.status === 200){
          await this.fetchBookList();
          this.deleteDialog = false;
        }
      },

    },
  }
</script>
