package hbcu.stay.ready.crudspringexample.services;

import hbcu.stay.ready.crudspringexample.models.Album;
import hbcu.stay.ready.crudspringexample.models.WutangMember;
import hbcu.stay.ready.crudspringexample.repos.AlbumRepo;
import hbcu.stay.ready.crudspringexample.repos.WutangMemberRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class WutangMemberService {

    private final Logger logger = LoggerFactory.getLogger(WutangMemberService.class);
    private WutangMemberRepo wutangMemberRepo;
    private AlbumRepo albumRepo;

    @Autowired
    public WutangMemberService(WutangMemberRepo wutangMemberRepo, AlbumRepo albumRepo){
        this.wutangMemberRepo = wutangMemberRepo;
        this.albumRepo = albumRepo;
    }

    public WutangMember create(WutangMember wutangMember){
        logger.info("Creating Wutang Member with name: {}", wutangMember.getFullName());
        wutangMember = wutangMemberRepo.save(wutangMember);
        return wutangMember;
    }

    public WutangMember find(Long id){
        logger.info("Getting Wutang Member with id: {}", id);
        Optional<WutangMember> wutangMemberOption = wutangMemberRepo.findById(id);
        return wutangMemberOption.get();
    }

    public Iterable<WutangMember> findAll(){
        logger.info("Getting all members of the Wu");
        Iterable<WutangMember> members = wutangMemberRepo.findAll();
        return members;
    }

    public WutangMember update(WutangMember wutangMember){
        logger.info("Updating Wutang Member with name: {}", wutangMember.getFullName());
        wutangMember = wutangMemberRepo.save(wutangMember);
        return wutangMember;
    }

    public void delete(Long id){
        WutangMember wutangMember = find(id);
        logger.info("Removing Wu Member: {}", wutangMember.getFullName());
        wutangMemberRepo.delete(wutangMember);
    }

    public Album addAlbum(Long memberId, Album album){
        WutangMember wutangMember = find(memberId);
        logger.info("Adding Album: {} to {}", album.getTitle(), wutangMember.getStageName());
        album.setWutangMember(wutangMember);
        album = albumRepo.save(album);
        return album;
    }
}
