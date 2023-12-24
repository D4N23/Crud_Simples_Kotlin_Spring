package com.webservice.webservice.repository

import com.webservice.webservice.model.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note, Long>{
}