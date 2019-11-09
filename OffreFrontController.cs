using Service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WebApp.Controllers
{
    public class OffreFrontController : Controller
    {
        // GET: oooo
        OffreService OS;
        ProduitService PS;

        public OffreFrontController()
        {
            OS = new OffreService();
            PS = new ProduitService();
        }


        public ActionResult Affichage()
        {
            return View(OS.GetAll());

        }


        // GET: Product/Details/5
        public ActionResult Details(int id)
        {
            return View(OS.GetById(id));
            //return View();

        }



    }
}