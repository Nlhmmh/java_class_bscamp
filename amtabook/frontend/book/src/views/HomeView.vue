<template>
  <div class="ma-5">
    <v-row>
      <h2 class="mb-3">Book Management</h2>
      <v-spacer></v-spacer>
      <v-btn icon @click="onClickCreateBtn()">
        <v-icon size="30">mdi-plus-box</v-icon>
      </v-btn>
    </v-row>
    <v-data-table
      :headers="tableHeaders"
      :items="booksList"
      :items-per-page="5"
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
          @click="onClickEditBtn(item)"
        >
          <v-icon>mdi-pencil</v-icon>
        </v-btn>

        <!-- Delete Book -->
        <v-btn color="red" fab x-small dark @click="onClickDeleteBtn(item)">
          <v-icon>mdi-delete</v-icon>
        </v-btn>
      </template>
    </v-data-table>
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

      createDialog: false,
      updateDialog: false,
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

    onClickEditBtn() {
      this.updateDialog = true;
    },

    onClickDeleteBtn(item) {
      this.deleteDialog = true;
      this.selectItem = item;
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
