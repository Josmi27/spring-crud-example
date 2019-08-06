package hbcu.stay.ready.crudspringexample.controllers;

import hbcu.stay.ready.crudspringexample.models.Album;
import hbcu.stay.ready.crudspringexample.models.WutangMember;
import hbcu.stay.ready.crudspringexample.services.WutangMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WutangMemberController {

    private WutangMemberService wutangMemberService;

    @Autowired
    public WutangMemberController(WutangMemberService wutangMemberService){
        this.wutangMemberService = wutangMemberService;
    }

    @GetMapping("/members")
    public ResponseEntity<Iterable<WutangMember>> getAll(){
        Iterable<WutangMember> members = wutangMemberService.findAll();
        ResponseEntity<Iterable<WutangMember>> responseEntity = new ResponseEntity<>(members, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/members")
    public ResponseEntity<WutangMember> post(@RequestBody WutangMember wutangMember){
        wutangMember = wutangMemberService.create(wutangMember);
        return new ResponseEntity<>(wutangMember, HttpStatus.CREATED);
    }

    @PostMapping("/members/{id}/add/album")
    public ResponseEntity<Album> postAddAlbumToArtist(@PathVariable("id") Long id, @RequestBody Album album){
        album = wutangMemberService.addAlbum(id, album);
        return new ResponseEntity<>(album, HttpStatus.CREATED);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<WutangMember> get(@PathVariable("id") Long id){
        WutangMember wutangMember = wutangMemberService.find(id);
        return new ResponseEntity<>(wutangMember, HttpStatus.OK);
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<WutangMember> put(@PathVariable("id") Long id, @RequestBody WutangMember wutangMember){
         wutangMember = wutangMemberService.update(wutangMember);
         return new ResponseEntity<>(wutangMember, HttpStatus.ACCEPTED);
    }



    @DeleteMapping("/members/delete/{id}")
    public ResponseEntity<WutangMember> delete(@PathVariable("id") Long id){
        wutangMemberService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
