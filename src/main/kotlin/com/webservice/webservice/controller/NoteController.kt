package com.webservice.webservice.controller

import com.webservice.webservice.model.Note
import com.webservice.webservice.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/notes")
class NoteController {

    @Autowired
   lateinit var repository: NoteRepository

    @GetMapping
    fun list(): List<Note>{
        return repository.findAll().toList()

    }

    @PostMapping
    fun add(@RequestBody note: Note): Note{
        return repository.save(note);
    }

    @PutMapping("{id}")
    fun alter(@PathVariable id: Long, @RequestBody note: Note) : Note{
        if(repository.existsById(id)){
            val safeNote = note.copy(id) //Note(id, note.title, note.description)
            repository.save(safeNote)
        }
        return Note()

    }

    @DeleteMapping("{id")
    fun delete(@PathVariable id: Long, ){
        if(repository.existsById(id)){
            repository.delete(id)
        }

    }
}