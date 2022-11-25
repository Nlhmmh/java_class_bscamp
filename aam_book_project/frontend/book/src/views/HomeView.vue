<template>
  <div class="ma-5">
    <v-row class="ma-0">
      <h1 class="mb-3">Book Management System</h1>
      <v-spacer></v-spacer>
      <v-btn icon @click="onClickCreateBtn()">
        <v-icon size="30">mdi-plus-box</v-icon>
      </v-btn>
    </v-row>

    <v-data-table class="elevation-4"
      :headers="tableHeaders"
      :items="bookList"
      :items-per-page="5">

        <template v-slot:item.btn="{item}">

          <v-btn class="mr-3" color="primary" fab x-small @click="onClickEditBtn(item)">
            <v-icon>mdi-pencil</v-icon>
          </v-btn>

          <v-btn color="red" fab x-small dark @click="onClickDeleteBtn(item)">
            <v-icon>mdi-delete</v-icon>
          </v-btn>

        </template>

    </v-data-table>

    <v-dialog v-model="createDialog" width="500">
      <v-card>

        <v-card-title>Create Book</v-card-title>

        <v-card-text>
          <v-form ref="createBookForm" v-model="createBookForm">

            <v-text-field v-model="name" label="Name" placeholder="Enter Book Name"
              :rules="[(v) => !!v || 'Required']" required>
            </v-text-field>

            <v-text-field v-model="author" label="Author" placeholder="Enter Author Name"
              :rules="[(v) => !!v || 'Required']" required>
            </v-text-field>

            <v-text-field v-model="price" label="Price" placeholder="100" type="number"
              :rules="[(v) => !!v || 'Required']" required>
            </v-text-field>

            <v-select v-model="type" label="Type"
              :items="['romance','adventure','Horror']"
              :rules="[(v) => !!v || 'Required']" required>
            </v-select>

            <v-btn class="mt-5 width-100" color="success" @click="createBook()">
              Create
            </v-btn>

          </v-form>
        </v-card-text>

      </v-card>
    </v-dialog>

    <v-dialog v-model="editDialog" width="500">
      <v-card>

        <v-card-title>Edit Book</v-card-title>

        <v-card-text>
          <v-form ref="editBookForm" v-model="editBookForm">

            <v-text-field v-model="name" label="Name" placeholder="Enter Book Name"
              :rules="[(v) => !!v || 'Required']" required>
            </v-text-field>

            <v-text-field v-model="author" label="Author" placeholder="Enter Author Name"
              :rules="[(v) => !!v || 'Required']" required>
            </v-text-field>

            <v-text-field v-model="price" label="Price" placeholder="100" type="number"
              :rules="[(v) => !!v || 'Required']" required>
            </v-text-field>

            <v-select v-model="type" label="Type"
              :items="['romance','adventure','Horror']"
              :rules="[(v) => !!v || 'Required']" required>
            </v-select>

            <v-btn class="mt-5 width-100" color="success" @click="editBook()">
              Edit
            </v-btn>

          </v-form>
        </v-card-text>

      </v-card>
    </v-dialog>

    <v-dialog v-model="deleteDialog" width="500">
      <v-card>

        <v-card-title>Delete Book</v-card-title>

        <v-card-text>
          You are going to delete this book
          <br>
          <v-row class="pa-5">
            <v-col cols="4" class="pa-0">ID : </v-col>
            <v-col cols="8" class="pa-0">{{toDeleteBook.id}}</v-col>
            <v-col cols="4" class="pa-0">Name : </v-col>
            <v-col cols="8" class="pa-0">{{toDeleteBook.name}}</v-col>
          </v-row>
        </v-card-text>

        <v-card-actions>
          <v-btn @click="deleteDialog = false">Cancel</v-btn>
          <v-btn color="red" dark @click="deleteBook(toDeleteBook.id)">Delete</v-btn>
        </v-card-actions>

      </v-card>
    </v-dialog>
</div>
</template>

<script>
  import api from "../utils/api.js"

  export default {
    name: 'Home',

    components: {
    },

    data(){
      return {
        tableHeaders: [
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
            sortable: true,
          },
          {
            text: 'Created At',
            value: 'createdAt',
          },
          {
            text: 'Updated At',
            value: 'updateAt',
          },
          {
            text: 'Actions',
            value: 'btn',
          },
        ],
        bookList: [
          // {
          //   id: 1,
          //   name: "asdf",
          //   author: "fdsa",
          //   price: 321,
          //   type: "adventure",
          //   publishedDate: "111111",
          //   createdAt: "222222",
          //   updateAt: "333333",
          // }
        ],
        toEditId: 0,
        name: "",
        author: "",
        price: 0,
        type: "romance",
        deleteDialog: false,
        toDeleteBook: {},
        createDialog: false,
        createBookForm: false,
        editDialog: false,
        editBookForm: false,
      };
    },

    async created(){
      await this.fetchBookList();
    },

    methods: {
      async fetchBookList(){
        const resp = await api.get("/api/getAll");

        if(resp && resp.status == 200){
          const data = await resp.json();

          if(data){
            this.bookList = data;
          }
        }
      },

      onClickCreateBtn(){
        this.createDialog = true;
      },

      async createBook(){
        if(this.$refs.createBookForm.validate()){
          let createData = {
            name: this.name,
            author: this.author,
            price: this.price,
            type: this.type,
            publishedDate: "2020-1-1"
          }

          const resp = await api.post("/api/create", createData);

          if(resp && resp.status == 200){
            await this.fetchBookList();
            this.createDialog = false;
            this.name = "";
            this.author = "";
            this.price = 0;
            this.type = "romance";
          }
        }
      },

      onClickEditBtn(item){
        this.toEditId = item.id;
        this.name = item.name;
        this.author = item.author;
        this.price = item.price;
        this.type = item.type;
        this.editDialog = true;
      },

      async editBook(){
        if(this.$refs.editBookForm.validate()){
          let editData = {
            id: this.toEditId,
            name: this.name,
            author: this.author,
            price: this.price,
            type: this.type,
            publishedDate: "2020-1-1"
          }

          const resp = await api.put("/api/update", editData);

          if(resp && resp.status == 200){
            await this.fetchBookList();
            this.editDialog = false;
          }
        }
      },

      onClickDeleteBtn(item){
        this.toDeleteBook = item;
        this.deleteDialog = true;
      },

      async deleteBook(bookId){
        const resp = await api.deleteMethod("/api/delete", {id: bookId});

        if(resp && resp.status == 200){
          await this.fetchBookList();
          this.deleteDialog = false;
        }
      }
    },
  }
</script>
