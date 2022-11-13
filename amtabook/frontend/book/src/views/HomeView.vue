<template>
  <div class="ma-5">
    <v-row class="mb-3">
      <h2>Book Management</h2>
      <v-spacer></v-spacer>
      <!-- <v-btn icon @click="onClickCreateBtn()">
        <v-icon size="30">mdi-plus-box</v-icon>
      </v-btn> -->
      <v-btn color="primary" @click="onClickCreateBtn()">
        <v-icon left> mdi-plus </v-icon>
        Add
      </v-btn>
    </v-row>
    <v-data-table
      :headers="tableHeaders"
      :items="booksList"
      :items-per-page="10"
      class="elevation-1"
    >
      <template v-slot:item.actions="{ item }">
        <!-- Edit Book -->
        <v-btn
          class="mr-3"
          color="primary"
          fab
          x-small
          dark
          @click="onClickUpdateBtn(item)"
        >
          <v-icon>mdi-pencil</v-icon>
        </v-btn>

        <!-- Delete Book -->
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
            <v-text-field
              v-model="name"
              label="Name"
              placeholder="Enter your name"
              required
              :rules="[(v) => !!v || 'Required']"
            >
            </v-text-field>
            <v-text-field
              v-model="author"
              label="Author"
              placeholder="Enter author name"
              required
              :rules="[(v) => !!v || 'Required']"
            >
            </v-text-field>
            <v-text-field
              v-model="price"
              label="Price"
              placeholder="Enter book price"
              type="number"
              required
              :rules="[(v) => !!v || 'Required']"
            >
            </v-text-field>
            <v-select
              v-model="type"
              :items="['adventure', 'comedy', 'technology', 'romance']"
              label="Book Type"
              required
              placeholder="Select type..."
              :rules="[(v) => !!v || 'Required']"
            >
            </v-select>
            <v-menu
              ref="menu"
              v-model="menu"
              :close-on-content-click="false"
              :return-value.sync="publishedDate"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="publishedDate"
                  label="Published Date"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker v-model="publishedDate" no-title scrollable>
                <v-spacer></v-spacer>
                <v-btn text color="primary" @click="menu = false">
                  Cancel
                </v-btn>
                <v-btn text color="primary" @click="$refs.menu.save(publishedDate)">
                  OK
                </v-btn>
              </v-date-picker>
            </v-menu>
          </v-form>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn @click="createDialog = false">Cancel</v-btn>
          <v-btn color="primary" dark @click="createBook()">Create</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

  
    <v-dialog v-model="updateDialog" width="500">
      <v-card>
        <v-card-title>Update Book</v-card-title>
        <v-card-text>
          <v-form ref="updateBookForm" v-model="updateBookForm">
            <v-text-field
              v-model="name"
              label="Name"
              placeholder="Enter your name"
              required
              :rules="[(v) => !!v || 'Required']"
            >
            </v-text-field>
            <v-text-field
              v-model="author"
              label="Author"
              placeholder="Enter author name"
              required
              :rules="[(v) => !!v || 'Required']"
            >
            </v-text-field>
            <v-text-field
              v-model="price"
              label="Price"
              placeholder="Enter book price"
              type="number"
              required
              :rules="[(v) => !!v || 'Required']"
            >
            </v-text-field>
            <v-select
              v-model="type"
              :items="['adventure', 'comedy', 'technology', 'romance']"
              label="Book Type"
              required
              placeholder="Select type..."
              :rules="[(v) => !!v || 'Required']"
            >
            </v-select>
            <v-menu
              ref="menu"
              v-model="menu"
              :close-on-content-click="false"
              :return-value.sync="publishedDate"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="publishedDate"
                  label="Published Date"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker v-model="publishedDate" no-title scrollable>
                <v-spacer></v-spacer>
                <v-btn text color="primary" @click="menu = false">
                  Cancel
                </v-btn>
                <v-btn text color="primary" @click="$refs.menu.save(publishedDate)">
                  OK
                </v-btn>
              </v-date-picker>
            </v-menu>
          </v-form>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn @click="updateDialog = false">Cancel</v-btn>
          <v-btn color="primary" dark @click="updateBook()">Update</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>


    <v-dialog v-model="deleteDialog" width="500">
      <v-card>
        <v-card-title>Delete Book</v-card-title>
        <v-card-text> Are you sure to delete this book? </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn @click="deleteDialog = false">Cancel</v-btn>
          <v-btn color="red" dark @click="deleteBook(selectItem.id)"
            >Delete</v-btn
          >
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import api from "../utils/api.js";

export default {
  name: "Home",

  components: {},

  data() {
    return {
      tableHeaders: [
        {
          text: "ID",
          value: "id",
          sortable: true,
        },
        {
          text: "Name",
          value: "name",
          sortable: true,
        },
        {
          text: "Author",
          value: "author",
          sortable: true,
        },
        {
          text: "Price",
          value: "price",
          sortable: true,
        },
        {
          text: "Type",
          value: "type",
        },
        {
          text: "Published Date",
          value: "publishedDate",
          sortable: true,
        },
        {
          text: "Created At",
          value: "createdAt",
        },
        {
          text: "Updated At",
          value: "updatedAt",
        },
        { text: "Actions", value: "actions", sortable: false },
      ],

      booksList: [],
      selectItem: {},

      //For Create book
      createDialog: false,
      name: "",
      author: "",
      price: 0,
      type: "romance",
      publishedDate: "2020-10-02",
      createBookForm: false,

      toEditID: 0,
      updateDialog: false,
      updateBookForm:false,
      menu:"",

      deleteDialog: false,
    };
  },

  async created() {
    await this.fetchBookList();
  },

  methods: {
    async fetchBookList() {
      const res = await api.getAll("/api/books");
      if (res && res.status === 200) {
        const data = await res.json();
        if (data) {
          this.booksList = data;
        }
      }
    },
    onClickCreateBtn() {
      this.createDialog = true;
    },

    onClickUpdateBtn(item) {
      this.updateDialog = true;
      this.toEditID = item.id;
      this.name = item.name;
      this.author = item.author;
      this.price = item.price;
      this.type = item.type;
      this.publishedDate = item.publishedDate;
    },

    onClickDeleteBtn(item) {
      this.deleteDialog = true;
      this.selectItem = item;
    },

    async createBook() {
      if (this.$refs.createBookForm.validate()) {
        const res = await api.post("/api/books", {
          name: this.name,
          author: this.author,
          price: this.price,
          type: this.type,
          publishedDate: this.publishedDate,
        });
        if (res && res.status === 200) {
          await this.fetchBookList();
          this.createDialog = false;
          this.name = "";
          this.author = "";
          this.price = 0;
          this.type = "romance";
          this.publishedDate = "2020-10-02";
        }
      }
    },
    async updateBook() {
      if (this.$refs.updateBookForm.validate()) {
        const res = await api.put("/api/books", {
          id: this.toEditID,
          name: this.name,
          author: this.author,
          price: this.price,
          type: this.type,
          publishedDate: this.publishedDate,
        });
        if (res && res.status === 200) {
          await this.fetchBookList();
          this.updateDialog = false;
          this.name = "";
          this.author = "";
          this.price = 0;
          this.type = "romance";
          this.publishedDate = "2020-10-02";
        }
      }
    },
    async deleteBook(id) {
      const res = await api.del("/api/books", {
        id,
      });
      if (res && res.status === 200) {
        await this.fetchBookList();
        this.deleteDialog = false;
      }
    },
  },
};
</script>
