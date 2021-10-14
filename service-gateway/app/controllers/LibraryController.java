package controllers;

import com.encentral.library.api.ILibrary;
import com.encentral.library.model.Library;
import com.encentral.scaffold.commons.util.MyObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.*;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;


@Transactional
@Api(value = "Library")
public class LibraryController extends Controller {


    @Inject
    ILibrary iLibrary;

    @Inject
    FormFactory formFactory;

    @Inject
    MyObjectMapper objectMapper;




    @ApiOperation(value = "Create New Library")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, response = Library.class, message = "Newly created Library")}
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "body",
                    value = "Library details",
                    paramType = "body",
                    required = true,
                    dataType = "com.encentral.library.model.Library"
            )
    })
    public Result addLibrary() throws JsonProcessingException {
        Form<Library> libraryForm = formFactory.form(Library.class).bindFromRequest();
        if (libraryForm.hasErrors()) {
            return badRequest(libraryForm.errorsAsJson());
        }
        return ok(objectMapper.writeValueAsString(iLibrary.addLibrary(libraryForm.get())));
    }


    @ApiOperation(value = "Get a Library")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, response = Library.class, message = "found Library")}
    )
    @ApiImplicitParams({
    })
    public Result getLibrary(String libraryId) {
        try {
            return iLibrary.getLibrary(libraryId)
                    .map(library -> ok(objectMapper.toJsonString(library)))
                    .orElse(notFound());

        } catch (Exception ex) {
            return badRequest(ex.getMessage());
        }


    }


}
