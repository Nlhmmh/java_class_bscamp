<template>
  <div class="ma-5">
    <!-- Title, Create Book -->
    <v-row class="ma-0">
      <h1 class="mb-3">Book Management System</h1>
      <v-spacer></v-spacer>
      <v-btn icon @click="onClickCreateBtn()">
        <v-icon size="30">mdi-plus-box</v-icon>
      </v-btn>
    </v-row>

    <!-- Book Table -->
    <v-data-table
      class="elevation-4"
      :headers="tableHeaders"
      :items="bookList"
      :items-per-page="5"
    >
      <template v-slot:item.actions="{ item }">
        <!-- Edit Book -->
        <v-btn
          class="mr-3"
          color="primary"
          fab
          x-small
          dark
          @click="onClickEditBtn()"
        >
          <v-icon>mdi-pencil</v-icon>
        </v-btn>

        <!-- Delete Book -->
        <v-btn color="red" fab x-small dark @click="onClickDeleteBtn(item)">
          <v-icon>mdi-delete</v-icon>
        </v-btn>
      </template>
    </v-data-table>

    <!-- Create Dialog -->
    <v-dialog v-model="createDialog" width="500">
      <v-card>
        <v-card-title>Create Book</v-card-title>
      </v-card>
    </v-dialog>

    <!-- Delete Dialog -->
    <v-dialog v-model="deleteDialog" width="500">
      <v-card>
        <v-card-title>Delete Book</v-card-title>
        <v-card-text>
          You are going to delete this book
          <v-row class="pa-5">
            <v-col cols="4" class="pa-0">ID : </v-col>
            <v-col cols="8" class="pa-0">{{ toDeleteBook.id }}</v-col>
            <v-col cols="4" class="pa-0">Name : </v-col>
            <v-col cols="8" class="pa-0"> {{ toDeleteBook.name }}</v-col>
          </v-row>
        </v-card-text>
        <v-card-actions>
          <v-btn @click="deleteDialog = false">Cancel</v-btn>
          <v-btn color="red" dark @click="deleteBook(toDeleteBook.id)"
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
      bookList: [],

      deleteDialog: false,
      toDeleteBook: {},

      createDialog: false,
    };
  },

  // Run once when screen is loaded
  async created() {
    await this.fetchBookList();
  },

  methods: {
    async fetchBookList() {
      const resp = await api.get("/api/book");
      if (resp && resp.status === 200) {
        const data = await resp.json();
        if (data) {
          this.bookList = data;
        }
      }
    },

    onClickCreateBtn() {
      this.createDialog = true;
    },

    onClickEditBtn() {},

    onClickDeleteBtn(item) {
      this.toDeleteBook = item;
      this.deleteDialog = true;
    },

    async deleteBook(toDeleteID) {
      const resp = await api.del("/api/book", {
        id: toDeleteID,
      });
      if (resp && resp.status === 200) {
        await this.fetchBookList();
        this.deleteDialog = false;
      }
    },
  },
};
</script>
